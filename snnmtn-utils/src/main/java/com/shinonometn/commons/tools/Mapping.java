package com.shinonometn.commons.tools;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Mapping {
    private Mapping(){}

    public static <I, O> Map<I, O> from(Collection<O> collection, Function<O, I> indexProvider) {
        return collection.stream().collect(Collectors.toMap(indexProvider, i -> i));
    }

    public static <I, O> Map<I, O> mapFrom(Collection<O> collection, Function<O, I> indexProvider) {
        return from(collection, indexProvider);
    }
}
