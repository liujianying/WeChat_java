package com.tencent.mm.plugin.boots.b;

public final class a extends RuntimeException {
    public a(String str) {
        super("Luggage Exception:" + str);
    }

    public a(String str, Throwable th) {
        super("Luggage Exception:" + str, th);
    }
}
