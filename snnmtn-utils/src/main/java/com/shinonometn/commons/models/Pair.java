package com.shinonometn.commons.models;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Pair<A, B> {
    private A a;
    private B b;

    public Pair() {
    }

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    public static <A, B> Pair<A, B> pair(A a, B b) {
        return new Pair<>(a, b);
    }

    public static <A, B> Map<A, B> toMap(Collection<Pair<A, B>> pairs) {
        return pairs.stream().collect(Collectors.toMap(Pair::getA, Pair::getB));
    }
}
