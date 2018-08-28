package com.tencent.mm.plugin.appbrand.widget.input.c;

public enum b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4);
    
    public final int gLq;

    private b(int i) {
        this.gLq = i;
    }

    public static b aqj() {
        return DONE;
    }

    public static b wj(String str) {
        return (b) d.h(str, b.class);
    }
}
