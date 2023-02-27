package org.sebastiansantis.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Hash {

    private static final Random rand = new Random();

    private Hash(){/*Utility Class*/}

    public static byte[] generateSalt() {
        byte[] salt = new byte[16];
        rand.nextBytes(salt);
        return salt;
    }

    public static byte[] generateHash(String input, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        return md.digest(input.getBytes());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
