package com.tencent.mm.plugin.appbrand.q;

public final class k {
    public static String bq(Object obj) {
        return "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : "null");
    }

    public static String bT(long j) {
        return "Token@" + j;
    }
}
