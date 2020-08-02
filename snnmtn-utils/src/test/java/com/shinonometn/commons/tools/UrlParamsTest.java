package com.shinonometn.commons.tools;

import com.shinonometn.commons.models.Pair;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class UrlParamsTest {

    private final Logger logger = Logger.getLogger("url-params-test");

    @Test
    public void encodeParamMap() {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("param1", "a");
        map.put("param2", "b");
        map.put("param3", "c");

        String result = UrlParams.encodeParamMap(map);
        logger.info("url format: " + result);
        assertEquals("param1=a&param2=b&param3=c", result);
    }

    @Test
    public void parseParamMap() {
        String url = "a=b&c=&d=c";
        Map<String,String> map = UrlParams.parseParamMap(url);

        assertEquals("b", map.get("a"));
        assertNull(map.get("c"));
        assertEquals("c", map.get("d"));
    }

    @Test
    public void encodePair() {
        String pair = UrlParams.encodePair(Pair.of("a","b"));

        logger.info("Pair: " + pair);

        assertEquals("a=b", pair);
    }

    @Test
    public void encodePairs() {
        String pairs = UrlParams.encodePairs(Arrays.asList(
                Pair.of("a", "b"),
                Pair.of("b", "c"),
                Pair.of("c", "d")
        ));

        logger.info("Pairs: " + pairs);
        assertEquals("a=b&b=c&c=d", pairs);
    }

    @Test
    public void concat() {
        String result = UrlParams.concat("a=b", "c=d");
        logger.info("Concat: " + result);
        assertEquals("a=b&c=d", result);
    }

    @Test
    public void encodeList() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        String result = UrlParams.encodeList(list);
        logger.info("List: " + result);
        assertEquals("a,b,c,d", result);
    }

    @Test
    public void decodeList() {
        Collection<String> list = UrlParams.parseList("a,b,c,d");
        assertTrue(list.containsAll(Arrays.asList("a", "b", "c", "d")));
    }
}