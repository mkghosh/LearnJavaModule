/*
Kasun De Zoysa @ UCSC
*/

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;

/*1. You should write a program (example RSASignature.java) to illustrate
RSA signature creation and verification as follows.
2. When you run the program (example java RSASignature "Your Message"),
It should print the signature of the message on the console.
3. Then you extend you program to verify the signature as well.
(Sample code RSASignature.java available on github)
4.You should e-mail your program file to BDREN (email: fdludcf@bdren.net.bd)
5. Deadline is 29th February 2020
*/
public class RSASignature {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (args.length == 1) {
            sb.append(args[0]);
        } else if (args.length > 1) {
            for (String arg : args) {
                sb.append(arg);
                sb.append(" ");
            }
        } else {
            System.out.println("Please provide your message to generate and verify signature for.");
        }
        String message = sb.toString();
        System.out.println("=======================================================");
        System.out.println("Initializing Signature Generation");
        System.out.println("Your Message is below : \n" + message);

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();

        Signature signature = Signature.getInstance("SHA1withRSA");

        // generate a signature
        signature.initSign(keyPair.getPrivate());

        //Create a signature of command line message
        signature.update(message.getBytes());
        byte[] sigBytes = signature.sign();
        System.out.println("The Signature of your message is : " + sigBytes.toString());
        System.out.println("=======================================================");

        // verify a signature
        //You shoud implement verification steps
        System.out.println("\n=======================================================");
        System.out.println("Initializing verification");
        signature.initVerify(keyPair.getPublic());
        /*
        You can give a different message here if you want to test.
         */
        signature.update(message.getBytes());
        if (signature.verify(sigBytes)) {
            System.out.println("The Signature is verified successfully");
        } else {
            System.out.println("The signature verification failed.");
        }
        System.out.println("=======================================================");
    }

}
