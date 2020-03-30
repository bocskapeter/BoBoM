package eu.bopet.bobom.core;

import eu.bopet.bobom.core.entities.Boms;
import eu.bopet.bobom.core.entities.DBEntities;
import eu.bopet.bobom.core.entities.Items;
import eu.bopet.bobom.core.entities.Users;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class BoMManager {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final EntityManager em;

    public BoMManager(final EntityManager em) {
        this.em = em;
    }

    public BoMMessage processMessage(BoMMessage message) {
        switch (message.getActivity()) {
            case LOGIN: {
                Users user = getUserByEMail((String) message.getList().get(0));
                return new BoMMessage(BoMActivity.LOGIN,Users.class,user,null);
            }
            case READ:{
                List<DBEntities> result = getAll(message.getTheClass());
                return new BoMMessage(BoMActivity.READ,message.getTheClass(),message.getUser(),result);
            }
            case SAVE: {
                try {
                    List<DBEntities> result = save(message.getList(), message.getUser());
                    return new BoMMessage(BoMActivity.SAVED,message.getTheClass(),message.getUser(),result);
                } catch (BoMLoopException e) {
                    logger.warning(message.getUser().toString() + e.getMessage());
                    return new BoMMessage(BoMActivity.ERROR,null,null,Arrays.asList(message));
                }
            }
            case DELETE:{
                if(delete((DBEntities) message.getList().get(0),message.getUser())){
                    return new BoMMessage(BoMActivity.DELETED,message.getTheClass(),message.getUser(),null);
                } else {
                    return new BoMMessage(BoMActivity.ERROR,null,null,Arrays.asList(message));
                }
            }
        }
        return new BoMMessage(BoMActivity.ERROR,null,null, Arrays.asList(message));
    }

    private Users getUserByEMail(String eMail) {
        logger.warning("Queried e-mail for user: \"" + eMail + "\"");
        try {
            return em.createNamedQuery("Users.findByEMail", Users.class).setParameter("eMail", eMail).getSingleResult();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }

    private <T> List<T> getAll(Class<T> entityClass) {
        try {
            return em.createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return null;
        }
    }

    private List<DBEntities> save(List<DBEntities> entities, Users user) throws BoMLoopException {
        List<DBEntities> result = new ArrayList<>();
        if (entities.isEmpty()) {
            return result;
        }
        if (entities.get(0) instanceof Boms) {
            return saveBom((List<Boms>) (List<?>) entities, user);
        }
        try {
            for (DBEntities entity : entities) {
                DBEntities fromDB = getById(entity.getId(), entity.getClass(), user);
                if (fromDB != null) {
                    fromDB = em.merge(entity);
                    result.add(fromDB);
                } else {
                    em.persist(entity);
                    result.add(getById(entity.getId(), entity.getClass(), user));
                }
            }
            return result;
        } catch (Exception e) {
            logger.warning(user.toString() + e.getMessage());
            return null;
        }
    }

    private boolean delete(DBEntities entity, Users user) {
        logger.warning(user.toString() + "deletes: " + entity.toString());
        DBEntities fromDB = em.find(entity.getClass(), entity.getId());
        if (fromDB != null) {
            try {
                em.remove(fromDB);
                return true;
            } catch (Exception e) {
                logger.warning(user.toString() + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    private DBEntities getById(UUID id, Class entityClass, Users user) {
        TypedQuery<DBEntities> tq = em.createNamedQuery(entityClass.getSimpleName() + ".findById", entityClass);
        try {
            return tq.setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            logger.warning(user.toString() + e.getMessage());
            return null;
        }
    }

    private List<DBEntities> saveBom(List<Boms> bom, Users user) throws BoMLoopException {
        List<DBEntities> result = new ArrayList<>();

        if (isLoop(bom.get(0).getAssembly(), bom)) {
            return result;
        }
        if (!uniquePositions(bom)) {
            return result;
        }

        List<Boms> bomsFromDB = getBom(bom.get(0).getAssembly());
        List<Boms> toBeDeletedPositions = new ArrayList<>();

        Boms toDelete;
        for (Boms b : bomsFromDB) {
            toDelete = b;
            for (Boms bomPosition : bom) {
                if (bomPosition.getId().equals(b.getId())) {
                    toDelete = null;
                    break;
                }
            }
            if (toDelete != null) {
                toBeDeletedPositions.add(toDelete);
            }
        }
        if (!toBeDeletedPositions.isEmpty()) {
            for (Boms b : toBeDeletedPositions) {
                if (!delete(b, user)) {
                    logger.warning("BoM not found to delete: " + b.toString() + " User: " + user.toString());
                }
            }
        }
        bomsFromDB = getBom(bom.get(0).getAssembly());

        for (Boms b : bomsFromDB) {
            b.setSeq(-b.getSeq());
        }
        for (Boms b : bomsFromDB) {
            em.merge(b);
        }
        for (Boms b : bomsFromDB) {
            b.setSeq(-b.getSeq());
        }
        for (Boms b : bomsFromDB) {
            em.merge(b);
        }

        for (Boms bomPosition : bom) {
            Boms bomPosFromDB = (Boms) getById(bomPosition.getId(), Boms.class, user);
            if (bomPosFromDB == null) {
                em.persist(bomPosition);
            }
            result.add(bomPosition);
        }
        return result;
    }

    private boolean uniquePositions(List<Boms> bom) {
        List<Integer> positions = new ArrayList<>();
        for (Boms b : bom) {
            if (positions.contains(b.getSeq())) {
                return false;
            } else {
                positions.add(b.getSeq());
            }
        }
        return true;
    }

    private boolean isLoop(Items assembly, List<Boms> bom) throws BoMLoopException {
        for (Boms b : bom) {
            if (b.getComponent() == assembly) {
                throw new BoMLoopException();
            } else {
                TypedQuery<Boms> tq = em.createNamedQuery("Boms.findByAssembly", Boms.class);
                try {
                    List<Boms> bomFromDB = tq.setParameter("assembly", b.getComponent()).getResultList();
                    if (isLoop(assembly, bomFromDB)) {
                        return true;
                    }
                } catch (Exception e) {
                    logger.warning(assembly.toString() + " --> " + e.getMessage());
                }
            }
        }
        return false;
    }

    private List<Boms> getBom(Items assembly) {
        List<Boms> result = new ArrayList<>();
        TypedQuery<Boms> tq = em.createNamedQuery("Boms.findByAssembly", Boms.class);
        try {
            result = tq.setParameter("assembly", assembly).getResultList();
        } catch (Exception e) {
            logger.warning(assembly.toString() + " --> " + e.getMessage());
            return result;
        }
        return result;
    }
}
