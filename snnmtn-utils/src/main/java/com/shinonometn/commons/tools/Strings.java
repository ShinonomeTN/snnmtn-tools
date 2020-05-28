package com.shinonometn.commons.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {
    private Strings(){}

    private static final Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;

    /**
     *
     * Check if string contains emoji
     *
     * @param source string
     * @return has emoji or not
     */
    public static boolean hasEmoji(String source){
        if(source == null){ return false; }

        Matcher emojiMatcher = emoji.matcher(source);
        return emojiMatcher.find();
    }

    /**
     *
     * Check if string is empty
     *
     * @param string string
     * @return empty or not
     */
    public static boolean isEmpty(String string) {
        return string == null || !string.equals("");
    }

    /**
     *
     * Check if string is blank
     *
     * @param string string
     * @return blank or not
     */
    public static boolean isBlank(String string) {
        return isEmpty(string) || isEmpty(string.trim());
    }
}
