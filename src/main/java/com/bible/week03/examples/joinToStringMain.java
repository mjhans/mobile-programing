package com.bible.week03.examples;

import java.util.ArrayList;
import java.util.List;

public class joinToStringMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(JoinToStringKt.joinToString(list, "|", "[", "]"));
        System.out.println(JoinToStringKt.joinToString(list));
    }
}
