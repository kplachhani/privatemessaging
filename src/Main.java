import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AESEncryptionDecription aesEncryptionDecription = new AESEncryptionDecription();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string to be encrypted : ");

        String input = scanner.nextLine();

        byte[] encrypted = aesEncryptionDecription.encryptDecrypt(input.getBytes(), EncryptDecryptMode.ENCRYPT_MODE);

        System.out.println("Encrypted : " + new String(encrypted));

        byte[] decrypted = aesEncryptionDecription.encryptDecrypt(encrypted, EncryptDecryptMode.DECRYPT_MODE);

        System.out.println("Decrypted : " + new String(decrypted));
    }
}
