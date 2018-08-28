package com.tencent.tencentmap.mapsdk.a;

public abstract class th extends ri {
    public th(int i) {
    }

    protected static int a(int i, int i2) {
        int i3 = i % i2;
        return i3 * i2 < 0 ? i3 + i2 : i3;
    }
}
