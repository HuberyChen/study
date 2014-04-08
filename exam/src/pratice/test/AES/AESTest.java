package pratice.test.aes;

import com.quidsi.core.crypto.AES;
import com.quidsi.core.json.JSONBinder;
import com.quidsi.core.util.CharacterEncodings;
import com.quidsi.core.util.EncodingUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hubery.chen
 */
@Component
public class AESTest {

    private final Map<String, SecretKey.Key> fixKeyMap = new HashMap<>();
    private final List<String> fixKeyList = new ArrayList<>();

    @Test
    public void test() {
        AES aes = new AES();
        String multiKeyJson = "{\"key\":[{\"KeyId\":\"vendor.email\",\"value\":\"6PSPv1SLACTpxdydG2fwD2oAb/qTgjtDcTqa0seseNA=\"}]}";
        SecretKey fixKey = JSONBinder.binder(SecretKey.class).fromJSON(multiKeyJson);
        for (SecretKey.Key key : fixKey.getKey()) {
            fixKeyMap.put(key.getKeyId(), key);
            fixKeyList.add(key.getKeyId());
        }
        aes.setKey(fixKeyMap.get(0).getValue());
        System.out.println(new String(aes.decrypt(EncodingUtils.decodeHex("4be865576ecdb39045017f9b08edbd9b")), CharacterEncodings.CHARSET_UTF_8));
    }

    public static class Key {

        @XmlElement(name = "KeyId")
        private String keyId;
        @XmlElement(name = "value")
        private byte[] value;

        public Key() {
        }

        public Key(String keyId, byte[] value) {
            this.keyId = keyId;
            this.value = value;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public byte[] getValue() {
            return value;
        }

        public void setValue(byte[] value) {
            this.value = value;
        }

    }

}
