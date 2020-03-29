package eu.bopet.bobom.server;

import eu.bopet.bobom.core.BoMMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class MessageDecoder implements Decoder.Text<BoMMessage> {

    @Override
    public BoMMessage decode(String s) throws DecodeException {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] data = decoder.decode(s);
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = null;
            is = new ObjectInputStream(in);
            return (BoMMessage) is.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
