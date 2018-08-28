package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ao {
    final int a;
    boolean b;
    String c;
    String d;
    long e;
    ar f;
    String g;
    int h;
    String i;
    long j;
    long k;
    long l;
    protected Object m;
    protected CountDownLatch n = new CountDownLatch(1);
    private boolean o;
    private bj p;
    private boolean q;

    public ao(int i, long j) {
        this.a = i;
        this.k = Millis100TimeProvider.INSTANCE.currentTimeMillis();
        this.e = j;
    }

    public void a() {
        this.l = Millis100TimeProvider.INSTANCE.currentTimeMillis() - this.k;
    }

    public Object b() {
        this.n.await(this.e, TimeUnit.MILLISECONDS);
        if (this.o) {
            throw new CancellationException();
        } else if (this.p != null) {
            throw this.p;
        } else if (this.q) {
            return this.m;
        } else {
            throw new bi(this.c + "." + this.d + " timout:" + this.e + " seq:" + this.a);
        }
    }

    public void a(bj bjVar) {
        this.p = bjVar;
        c();
    }

    protected void c() {
        this.n.countDown();
    }

    public String d() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public long e() {
        return this.e;
    }

    public String f() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public boolean g() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public int h() {
        return this.a;
    }

    public long i() {
        return this.k;
    }

    public long j() {
        return this.l;
    }

    public void a(long j) {
        this.j = j;
    }

    public String k() {
        return this.g;
    }

    public void c(String str) {
        this.g = str;
    }

    public int l() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public String m() {
        return this.i;
    }

    public void d(String str) {
        this.i = str;
    }

    public void a(ar arVar) {
        this.f = arVar;
    }
}
