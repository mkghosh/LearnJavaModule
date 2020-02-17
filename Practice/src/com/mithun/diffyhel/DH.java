package com.mithun.diffyhel;

import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;
import java.math.BigInteger;
import java.security.*;

public class DH {
    private final static BigInteger genrator = new BigInteger("6");
    private final static BigInteger prime = new BigInteger("13");

    /*
        The Fourth Assignment - DH Key exchanges
        ---------------------------------------------------
        1. You should write a program (example DH.java) to illustrate Diffie-Helllman (DH) algorithm as follows.
        2. Use generator g=6 and prime number p=13
        3. When you run the program (example java DH private_key) with a private key,
           It should print the public key on the console.
        4. When you run the program (example java DH private_key public_key) with private key and
           the recipient's public key, it should print the session key k on the console.
        5.You should e-mail your program file to BDREN (email: fdludcf@bdren.net.bd)
        6. Deadline is 25th February 2020.
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        DHParameterSpec dhParameterSpec = new DHParameterSpec(genrator, prime);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");

        if (args.length == 1) {
            keyPairGenerator.initialize(dhParameterSpec);
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            System.out.println("ALICE: Generate DH keypair ...");
            KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
            aliceKpairGen.initialize(2048);
            KeyPair aliceKpair = aliceKpairGen.generateKeyPair();
            KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
            aliceKeyAgree.init(aliceKpair.getPrivate());

            System.out.println(Long.parseLong(args[0]));
        } else if (args.length == 2) {
            //Long.parseLong(args[0]), Long.parseLong(args[1])
            System.out.println();
        } else {
            System.out.println("Please give private key to generate public key. \nOr private key and public key to generate session key.");
        }
    }
}
