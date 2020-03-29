package eu.bopet.bobom.server;

import eu.bopet.bobom.core.BoMManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class ServerContext {
    private static ServerContext serverContext = null;
    private final List<Session> sessions;
    private final BoMManager boMManager;

    private ServerContext() {
        this.sessions = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bobom");
        this.boMManager = new BoMManager(emf.createEntityManager());
    }

    public static ServerContext getInstance() {
        if (serverContext == null) {
            serverContext = new ServerContext();
        }
        return serverContext;
    }

    public List<Session> getSessions() {
        return this.sessions;
    }

    public void addSession(Session session) {
        if (!this.sessions.contains(session)) {
            this.sessions.add(session);
        }
    }

    public void removeSession(Session session) {
        if (this.sessions.contains(session)) {
            this.sessions.remove(session);
        }
    }

    public BoMManager getBoMManager() {
        return boMManager;
    }
}
