package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public final class fv implements fp {
    private static AtomicInteger k = new AtomicInteger(0);
    public gd a;
    public int b = 0;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public ep h;
    public long i;
    public int j;
    private gd l;
    private byte[] m;
    private int n = 0;

    public fv(gd gdVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = 0;
        this.j = 20;
        this.l = gdVar;
        this.n = k.getAndIncrement();
        this.l.a(this.n);
    }

    public final gd a() {
        return this.a;
    }

    public final void a(int i) {
        fu.a().a(this, 22);
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final ep d() {
        return this.h;
    }

    public final int e() {
        return this.d;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.f;
    }

    public final void i() {
        this.m = this.l.a();
    }

    public final int j() {
        return this.n;
    }

    public final byte[] k() {
        return this.m;
    }
}
