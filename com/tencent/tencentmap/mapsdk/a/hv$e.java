package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;

class hv$e {
    private int a;
    private ig b;
    private iw c;
    private int d;
    private int e;
    private Rect f;
    private int g;

    public synchronized boolean a() {
        return this.g == 2;
    }

    public synchronized void b() {
        this.g = 2;
        this.a = 0;
    }

    public boolean c() {
        return this.g == 1;
    }
}
