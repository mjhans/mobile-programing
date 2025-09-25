package com.bible.week03.examples;

import java.util.Collection;

public class StringUtils {
    public static <T> String joinToString(Collection<T> collection, String separator, String prefix, String postfix) {
        // 구현
        return "";
    }
    // 오버로드 메서드들도 수동 작성 필요...
    public static <T> String joinToString(Collection<T> collection, String separator, String prefix) {
        return joinToString(collection, separator, prefix, "");
    }

}
