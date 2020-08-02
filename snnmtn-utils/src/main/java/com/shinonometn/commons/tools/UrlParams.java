package com.shinonometn.commons.tools;

import com.shinonometn.commons.models.Pair;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public final class UrlParams {

    public final static String PAIR_SEPARATOR = "&";

    /**
     * Encode a string-to-string map into url parameters.
     *
     * It do url encoding for key and values. Only support utf8 encoding
     *
     * @param params the Map contains params
     * @return url parameter list
     */
    public static String encodeParamMap(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            try {
                sb.append(URLEncoder.encode(entry.getKey(), "UTF8"))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "UTF8"));

                if (iterator.hasNext()) sb.append(PAIR_SEPARATOR);
            } catch (UnsupportedEncodingException ignore) {
                // UTF8 will be always supported
            }
        }
        return sb.toString();
    }

    /**
     * Parse a url encoded param list to string Map.
     *
     * @param urlEncodedParams params
     * @return string map
     */
    public static Map<String, String> parseParamMap(String urlEncodedParams) {
        Map<String, String> paramMap = new HashMap<>();
        String[] pairs = urlEncodedParams.split(PAIR_SEPARATOR);
        for (String pair : pairs) {
            String[] s = pair.split("=");
            if (s.length == 0) continue;
            try {
                paramMap.put(s[0], s.length > 1 ? URLDecoder.decode(s[1], "UTF8") : null);
            } catch (UnsupportedEncodingException ignore) {
                // Always success
            }
        }

        return paramMap;
    }

    /**
     * Encode a Pair to url param pair
     *
     * @param pair kv pair
     * @return param pair
     */
    public static String encodePair(Pair<String, String> pair) {
        try {
            return URLEncoder.encode(pair.getA(), "UTF8") + "=" + URLEncoder.encode(pair.getB(), "UTF8");
        } catch (UnsupportedEncodingException e) {
            // ignored
            return null;
        }
    }

    /**
     * Encode a list of pairs to url param list
     *
     * @param pair paris
     * @return url params
     */
    public static String encodePairs(Collection<Pair<String, String>> pair) {
        Iterator<Pair<String, String>> iterator = pair.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(encodePair(iterator.next()));
            if (iterator.hasNext()) sb.append(PAIR_SEPARATOR);
        }
        return sb.toString();
    }

    /**
     * Concat two url param string
     *
     * @param paramGroup1 first
     * @param paramGroup2 second
     * @return concat result
     */
    public static String concat(String paramGroup1, String paramGroup2) {
        return paramGroup1 + PAIR_SEPARATOR + paramGroup2;
    }

    /**
     * Read list from url formatted list.
     *
     * @param urlListString list string, like 1,2,3,4,5 ....
     * @return string list
     */
    public static Collection<String> parseList(String urlListString) {
        return Arrays.asList(urlListString.split(","));
    }

    /**
     * Encode a string list to url format
     *
     * @param items items
     * @return list in url format
     */
    public static String encodeList(Collection<String> items) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            try {
                sb.append(URLEncoder.encode(item, "UTF8"));
            } catch (UnsupportedEncodingException ignored) {
                // UTF8 will be always supported
            }
            if (iterator.hasNext()) sb.append(",");
        }

        return sb.toString();
    }

}
