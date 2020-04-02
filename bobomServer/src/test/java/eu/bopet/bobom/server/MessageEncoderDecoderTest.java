package eu.bopet.bobom.server;

import eu.bopet.bobom.core.BoMActivity;
import eu.bopet.bobom.core.BoMMessage;
import eu.bopet.bobom.core.entities.Users;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MessageEncoderDecoderTest {
    @Test
    public void Test(){
        BoMMessage message = new BoMMessage(BoMActivity.LOGIN,Users.class,null, Arrays.asList("admin"));
        MessageEncoder encoder = new MessageEncoder();
        String encodedString = encoder.encode(message);
        MessageDecoder decoder = new MessageDecoder();
        BoMMessage decodedMessage = decoder.decode(encodedString);
        assert message.equals(decodedMessage);
    }
}
