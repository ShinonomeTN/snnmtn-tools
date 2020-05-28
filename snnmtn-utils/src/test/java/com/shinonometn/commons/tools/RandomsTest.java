package com.shinonometn.commons.tools;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class RandomsTest {

    private final static Logger logger = Logger.getLogger("randoms-test");

    @Test
    public void instance() {
        AtomicReference<Random> ref1 = new AtomicReference<>();
        AtomicReference<Random> ref2 = new AtomicReference<>();

        new Thread(() -> ref1.set(Randoms.instance())).start();
        new Thread(() -> ref2.set(Randoms.instance())).start();
        try {
            logger.info("Sleep 1000ms to wait thread works finish.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Random instance 1 : " + ref1.get().toString());
        logger.info("Random instance 2 : " + ref2.get().toString());
        assertNotEquals(ref1, ref2);
    }

    @Test
    public void randomTimeId() {
        String randomTimeId = Randoms.randomTimeId();
        logger.info("Random time id: " + randomTimeId);
    }

    @Test
    public void testRandomTimeId() {
        long time = System.currentTimeMillis();
        String randomTimeId = Randoms.randomTimeId(time);
        logger.info("Random time id: " + randomTimeId);
        assertTrue(randomTimeId.contains(String.valueOf(time)));
    }

    @Test
    public void randomUUID() {
        String randomUUID = Randoms.randomUUID();
        logger.info("Random uuid: " + randomUUID);
    }

    @Test
    public void randomString() {
        int length = Randoms.randomInt(6, 12);
        String randomString = Randoms.randomString(length);
        logger.info("Random string in " + length + " char(s): " + randomString);
        assertEquals(randomString.length(), length);
    }

    @Test
    public void testRandomString() {
        int length = Randoms.randomInt(1, 16);
        char[] charset = "{}[]|';\",.<>/?-_=+)(*&^%$#@!~`".toCharArray();
        String randomString = Randoms.randomString(length, charset);

        logger.info("Random string in " + length + " char(s): " + randomString);

        assertEquals(randomString.length(), length);
        Set<Character> set = new HashSet<>();
        for (char i : charset) set.add(i);
        boolean contains = true;
        for (char a : randomString.toCharArray()) {
            if (!set.contains(a)) {
                contains = false;
                logger.log(Level.WARNING, "Char " + a + " not belong to charset.");
                break;
            }
        }
        assertTrue(contains);
    }

    @Test
    public void randomNumberInString() {
        int length = Randoms.randomInt(1, 16);
        String randomNumber = Randoms.randomNumberInString(length);
        logger.info("Random number in length " + length + " : " + randomNumber);
        assertEquals(randomNumber.length(), length);
    }

    @Test
    public void randomInt() {
        int randomNumber = Randoms.randomInt(0, 100);
        logger.info("Random number in 0-100: " + randomNumber);
    }

    @Test
    public void random() {
        Random random = Randoms.instance();
        logger.info("Random instance: " + random.toString());
        assertNotNull(random);
    }
}