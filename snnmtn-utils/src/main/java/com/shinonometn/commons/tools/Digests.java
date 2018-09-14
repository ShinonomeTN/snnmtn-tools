package com.shinonometn.commons.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Digests {

    private final static MessageDigest md5Digest;
    private final static MessageDigest sha1Digest;

    private final static MessageDigest sha512Digest;

    static {
        try {
            md5Digest = MessageDigest.getInstance("MD5");
            sha1Digest = MessageDigest.getInstance("SHA-1");

            sha512Digest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) stringBuilder.append(s);

        return new String(Hex.encodeHex(md5Digest.digest(stringBuilder.toString().getBytes()), !upperCase));
    }

    /**
     *
     * Get SHA1 of some string
     *
     * @param upperCase if use uppercase string as result
     * @param strings contents
     * @return string
     */
    public static String getSha1(boolean upperCase, String... strings) {


        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) stringBuilder.append(s);

        return new String(Hex.encodeHex(sha1Digest.digest(stringBuilder.toString().getBytes()), !upperCase));
    }

    /**
     *
     * Get SHA512 of some string
     *
     * @param upperCase if use uppercase string as result
     * @param strings contents
     * @return string
     */
    public static String getSha512(boolean upperCase, String... strings) {


        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) stringBuilder.append(s);

        return new String(Hex.encodeHex(sha512Digest.digest(stringBuilder.toString().getBytes()), !upperCase));
    }
}
