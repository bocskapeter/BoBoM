package eu.bopet.bobom.server;

import eu.bopet.bobom.core.BoMMessage;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint(
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class,
        value = "/engineering")
public class EngineeringServerEndpoint {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        ServerContext.getInstance().addSession(session);
    }

    @OnMessage
    public void onMessage(Session session, BoMMessage message) {
        try {
            BoMMessage reply = ServerContext.getInstance().getBoMManager().processMessage(message);
            session.getBasicRemote().sendObject(reply);
        } catch (IOException | EncodeException e) {
            logger.warning(session.toString());
            logger.warning(message.toString());
            logger.warning(e.getLocalizedMessage());
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
