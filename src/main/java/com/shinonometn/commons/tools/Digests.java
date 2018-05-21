package com.shinonometn.commons.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Digests {

    /**
     *
     * Get MD5 of some strings
     *
     * @param upperCase if use uppercase string as result
     * @param strings contents
     * @return string
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(boolean upperCase, String... strings) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) stringBuilder.append(s);

        return new String(Hex.encodeHex(messageDigest.digest(stringBuilder.toString().getBytes()), !upperCase));
    }

    /**
     *
     * Get SHA1 of some string
     *
     * @param upperCase if use uppercase string as result
     * @param strings contents
     * @return string
     * @throws NoSuchAlgorithmException
     */
    public static String getSha1(boolean upperCase, String... strings) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) stringBuilder.append(s);

        return new String(Hex.encodeHex(messageDigest.digest(stringBuilder.toString().getBytes()), !upperCase));
    }
}
