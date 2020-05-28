package com.shinonometn.commons.tools;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Names {
    private Names(){}

    /**
     *
     * Get short class name from a list of Class
     *
     * @param classList Classes
     * @return list of short name
     */
    public static List<String> classShortNamesFrom(Collection<Class<?>> classList) {
        return classList.stream()
                .map(Class::getName)
                .map(Names::classShortNameFrom)
                .collect(Collectors.toList());
    }

    /**
     *
     * Get short class name of a class
     *
     * @param className class name
     * @return short class name
     */
    public static String classShortNameFrom(String className){
        return className.substring(className.lastIndexOf(".") + 1,className.length());
    }

    /**
     * Get file extension name
     *
     * @param filename file name
     * @return file extension name
     */
    public static String fileExtensionNameFrom(String filename){
        return filename.substring(filename.lastIndexOf("."),filename.length());
    }
}
