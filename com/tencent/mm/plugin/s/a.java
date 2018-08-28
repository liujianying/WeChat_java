package com.tencent.mm.plugin.s;

import java.util.List;

public final class a {
    private static List<a> kKB;
    private static String kKC;

    public static synchronized void l(String str, List<a> list) {
        synchronized (a.class) {
            kKC = str;
            kKB = list;
        }
    }

    public static synchronized List<a> FZ(String str) {
        List<a> list;
        synchronized (a.class) {
            if (str != null) {
                if (str.equals(kKC)) {
                    list = kKB;
                }
            }
            list = null;
        }
        return list;
    }
}
