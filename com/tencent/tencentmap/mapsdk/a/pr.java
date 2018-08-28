package com.tencent.tencentmap.mapsdk.a;

public class pr extends Exception {
    private Exception a;
    private int b;

    public pr(String str, Exception exception, int i) {
        super(str);
        this.a = exception;
        this.b = i;
    }
}
