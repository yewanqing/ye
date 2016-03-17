package rex;

import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by sh1 on 16-2-29.
 */
public class TestBase {
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;

    public static void main(String[] args) throws InvalidKeySpecException {
        try {
            String desKey = "0123456789abcdef0123456789abcdef0123456789abcdef"; // value from user
            byte[] keyBytes = DatatypeConverter.parseHexBinary(desKey);
            System.out.println((int)keyBytes.length);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = factory.generateSecret(new DESedeKeySpec(keyBytes));

            encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key); //throwing Exception
            byte[] encryptedData = encryptData("Confidential data");

            decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            byte iv[] = encryptCipher.getIV();
            IvParameterSpec dps = new IvParameterSpec(iv);
            try {
                decryptCipher.init(Cipher.DECRYPT_MODE, key, dps);
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }
//            decryptCipher.init(Cipher.DECRYPT_MODE, key);
           String encode="eqP0Mm2le18bDnccRQ6W1UZxii5MjZM7%2bgiinfYg5RAIywsJXRkAgg%3d%3d";
            BASE64Decoder base64Decoder = new BASE64Decoder();
            try {
                byte[] byteMi = base64Decoder.decodeBuffer(encode);
                decryptData(byteMi);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
    }

    private static byte[] encryptData(String data)
            throws IllegalBlockSizeException, BadPaddingException {
        System.out.println("Data Before Encryption :" + data);
        byte[] dataToEncrypt = data.getBytes();
        byte[] encryptedData = encryptCipher.doFinal(dataToEncrypt);
        System.out.println("Encryted Data: " + encryptedData);

        return encryptedData;
    }

    private static void decryptData(byte[] data)
            throws IllegalBlockSizeException, BadPaddingException {
        byte[] textDecrypted = decryptCipher.doFinal(data);
        System.out.println("Decryted Data: " + new String(textDecrypted));
    }

}