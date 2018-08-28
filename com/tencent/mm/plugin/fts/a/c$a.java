package com.tencent.mm.plugin.fts.a;

import java.util.regex.Pattern;

public final class c$a {
    public static final Pattern jqA = Pattern.compile("​");
    public static final Pattern jqB = Pattern.compile("‌");
    public static final Pattern jqC;
    public static final Pattern jqD;
    public static final Pattern jqE = Pattern.compile("\\s+");
    public static final Pattern jqF = Pattern.compile(",");
    public static final Pattern jqG = Pattern.compile("[A-Za-z]+");
    public static final Pattern jqy = Pattern.compile(";");
    public static final Pattern jqz = Pattern.compile(" ");

    static {
        Pattern compile = Pattern.compile("‍");
        jqC = compile;
        jqD = compile;
    }
}
