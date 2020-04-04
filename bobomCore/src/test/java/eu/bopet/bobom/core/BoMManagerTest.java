/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.bopet.bobom.core;

import eu.bopet.bobom.core.entities.DBEntities;
import eu.bopet.bobom.core.entities.Users;
import eu.bopet.bobom.core.entities.names.ItemNames;
import eu.bopet.bobom.core.entities.names.UnitSymbols;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bocskapeter
 */
public class BoMManagerTest {

    private EntityManager em;
    private BoMManager boMManager;

    public BoMManagerTest() {
    }

    private void createEntityManager() {
        if (this.em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("bobom-Test");
            this.em = emf.createEntityManager();
        }
    }

    private void createBoMManager() {
        if (this.boMManager == null) {
            createEntityManager();
            this.boMManager = new BoMManager(em);
        }
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetUserByEMail() {
        createBoMManager();
        BoMMessage message = new BoMMessage(BoMActivity.LOGIN, Users.class, null, Arrays.asList(new String[]{"admin"}));
        BoMMessage reply = boMManager.processMessage(message);
        assert reply.getUser().getEMail().equals("admin");
    }

    @Test
    public void testGetAll() {
        createBoMManager();
        BoMMessage message = new BoMMessage(BoMActivity.READ_ALL, UnitSymbols.class, null, null);
        BoMMessage reply = boMManager.processMessage(message);
        assert !reply.getList().isEmpty();
    }

    @Test
    public void testSave() throws Exception {
        createBoMManager();
        BoMMessage message = new BoMMessage(BoMActivity.LOGIN, Users.class, null, Arrays.asList(new String[]{"admin"}));
        BoMMessage reply = boMManager.processMessage(message);
        Users user = reply.getUser();
        assert user.getEMail().equals("admin");
        String[] names = {"EN", "DE", "HU"};
        ItemNames itemName = new ItemNames(names);
        message = new BoMMessage(BoMActivity.SAVE,ItemNames.class,user, Arrays.asList(new ItemNames[]{itemName}));
        reply = boMManager.processMessage(message);
        assert reply.getActivity().equals(BoMActivity.SAVED);
        assert reply.getList().get(0).equals(itemName);
        assert reply.getUser().equals(user);
        em.getTransaction().begin();
        em.flush();
        em.getTransaction().commit();
    }

    /**
     * Test of delete method, of class BoMManager.
     */
    @Test
    public void testDelete() {
        createBoMManager();
        BoMMessage message = new BoMMessage(BoMActivity.LOGIN, Users.class, null, Arrays.asList(new String[]{"admin"}));
        BoMMessage reply = boMManager.processMessage(message);
        Users user = reply.getUser();
        assert user.getEMail().equals("admin");
        String[] names = {"EN", "DE", "HU"};
        ItemNames itemName = new ItemNames(names);
        message = new BoMMessage(BoMActivity.SAVE,ItemNames.class,user, Arrays.asList(new ItemNames[]{itemName}));
        reply = boMManager.processMessage(message);
        assert reply.getActivity().equals(BoMActivity.SAVED);
        assert reply.getList().get(0).equals(itemName);
        assert reply.getUser().equals(user);
        em.getTransaction().begin();
        em.flush();
        em.getTransaction().commit();
        message = new BoMMessage(BoMActivity.DELETE,ItemNames.class,user, Arrays.asList(new ItemNames[]{itemName}));
        reply = boMManager.processMessage(message);
        assert reply.getActivity().equals(BoMActivity.DELETED);
    }
}
