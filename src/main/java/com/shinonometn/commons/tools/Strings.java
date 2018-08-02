package com.shinonometn.commons.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {
    private Strings(){}

    private static Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;

    public static boolean hasEmoji(String source){
        if(source == null){ return false; }

        Matcher emojiMatcher = emoji.matcher(source);
        return emojiMatcher.find();

    }
}
