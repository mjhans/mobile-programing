package com.bible.week03.examples;

public class TopLevel {
    public static void main(String[] args) {
        // getter/setter로 접근
        String separator = Constants.getUNIX_LINE_SEPARATOR();

        // 변경 가능한 프로퍼티
        Constants.setDebugMode(true);
        boolean debug = Constants.getDebugMode();

        // 계산된 프로퍼티
        String systemSep = Constants.getCurrentSystemLineSeparator();
    }
}
