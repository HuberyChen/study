package pratice.test.AES;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Echo
 * @version createTime：May 16, 2013 3:14:20 PM
 */
public class SecretKey {

    @XmlElement(name = "key")
    private final List<Key> key = new ArrayList<>();

    public List<Key> getKey() {
        return key;
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