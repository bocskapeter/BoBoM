package eu.bopet.bobom.server;

import eu.bopet.bobom.core.BoMActivity;
import eu.bopet.bobom.core.BoMMessage;
import eu.bopet.bobom.core.entities.Users;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

@ServerEndpoint(
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class,
        value = "/engineering/{eMail}")
public class EngineeringServerEndpoint {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(@PathParam("eMail") String eMail, Session session, EndpointConfig config) {
        logger.info("Connected ... " + session.getId());
        logger.warning("config: " + config.toString());
        try{
            BoMMessage message = new BoMMessage(BoMActivity.LOGIN,Users.class,null, Arrays.asList(new String[]{eMail}));
            BoMMessage reply = ServerContext.getInstance().getBoMManager().processMessage(message);
            Users user = reply.getUser();
            if (user!= null){
                session.getUserProperties().put("user",user);
                session.getBasicRemote().sendObject(reply);
            }
        } catch (Exception e){
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        ServerContext.getInstance().addSession(session);
    }

    @OnMessage
    public void onMessage(Session session, BoMMessage message){
        BoMMessage reply = ServerContext.getInstance().getBoMManager().processMessage(message);
        try {
            session.getBasicRemote().sendObject(reply);
        } catch (IOException | EncodeException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        ServerContext.getInstance().removeSession(session);
        logger.warning(String.format("Session %s error: %s", session.getId(), error.getMessage()));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        ServerContext.getInstance().removeSession(session);
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
}