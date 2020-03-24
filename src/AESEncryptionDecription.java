import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class AESEncryptionDecription {

    private Cipher cipher;
    private SecretKeySpec secretKey;

    protected AESEncryptionDecription() {

        try {
            cipher = Cipher.getInstance("AES", new BouncyCastleProvider());
        } catch (NoSuchAlgorithmException  | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    protected byte[] encryptDecrypt(byte[] plainText, EncryptDecryptMode mode) {
        generateKey();
        try {
            if(mode == EncryptDecryptMode.ENCRYPT_MODE){
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            } else if (mode == EncryptDecryptMode.DECRYPT_MODE) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            }
            else {
                System.out.println("Incorrect method");
                return null;
            }
            return cipher.doFinal(plainText);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void generateKey() {
        byte[] newkeyBytes = new byte[16];
        secretKey = new SecretKeySpec(newkeyBytes, "AES");
    }
}
