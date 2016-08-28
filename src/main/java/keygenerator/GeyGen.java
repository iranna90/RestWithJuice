package keygenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;


/**
 * Created by iranna.patil on 28-08-2016.
 */
public class GeyGen {

    private static final String ALGORITHM = "AES";

    public static void main(String[] args) throws Exception {
        System.out.println("started");

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16]; // 128 bits are converted to 16 bytes;
        random.nextBytes(bytes);
        UUID x = UUID.randomUUID();
        GeyGen geyGen = new GeyGen();
        //Key key = geyGen.generateKeyFromString(x);

        String original = "heloo";

        String encrypted = geyGen.encrypt(original, asBytes(x));

        String decrypted = geyGen.decrypt(encrypted, asBytes(x));

        System.out.println(original.equals(decrypted));
    }

    private Key generateKeyFromString(final byte[] secKey) throws Exception {
       // final byte[] keyVal = new BASE64Decoder().decodeBuffer(secKey);
        final Key key = new SecretKeySpec(secKey, ALGORITHM);
        return key;
    }

    public String encrypt(final String valueEnc, final byte[] secKey) {

        String encryptedVal = null;

        try {
            final Key key = generateKeyFromString(secKey);
            final Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            final byte[] encValue = c.doFinal(valueEnc.getBytes());
            encryptedVal = new BASE64Encoder().encode(encValue);
        } catch (Exception ex) {
            System.out.println("The Exception is=" + ex);
        }

        return encryptedVal;
    }

    public String decrypt(final String encryptedValue, final byte[] secretKey) {

        String decryptedValue = null;

        try {

            final Key key = generateKeyFromString(secretKey);
            final Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            final byte[] decorVal = new BASE64Decoder().decodeBuffer(encryptedValue);
            final byte[] decValue = c.doFinal(decorVal);
            decryptedValue = new String(decValue);
        } catch (Exception ex) {
            System.out.println("The Exception is=" + ex);
        }

        return decryptedValue;
    }
    public static UUID asUuid(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }

    public static byte[] asBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

}
