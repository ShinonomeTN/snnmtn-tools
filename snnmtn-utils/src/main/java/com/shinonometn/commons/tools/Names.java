package com.shinonometn.commons.tools;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Names {
    private Names(){}

    public static List<String> getShortClassNameList(Collection<Class<?>> classList) {
        return classList.stream()
                .map(Class::getName)
                .map(Names::getShortClassName)
                .collect(Collectors.toList());
    }

    public static String getShortClassName(String className){
        return className.substring(className.lastIndexOf(".") + 1,className.length());
    }

    public static String getFileExtendName(String filename){
        return filename.substring(filename.lastIndexOf("."),filename.length());
    }
}
