package com.tencent.tencentmap.mapsdk.a;

public class jj<E> {
    private int a;
    private volatile Object[] b;
    private volatile int c = 0;
    private volatile int d = 0;

    public jj(int i) {
        this.a = i;
        this.b = new Object[i];
    }

    private void e() {
        this.d = 0;
        this.c = 0;
    }

    public boolean a(E e) {
        if (c()) {
            return false;
        }
        this.d %= this.a;
        Object[] objArr = this.b;
        int i = this.d;
        this.d = i + 1;
        objArr[i] = e;
        return true;
    }

    public E a() {
        if (d()) {
            return null;
        }
        this.c %= this.a;
        E e = this.b[this.c];
        this.b[this.c] = null;
        this.c++;
        return e;
    }

    public void b() {
        e();
        for (int i = 0; i < this.b.length; i++) {
            this.b[i] = null;
        }
    }

    public boolean c() {
        return (this.d + 1) % this.a == this.c;
    }

    public boolean d() {
        return this.d == this.c;
    }
}
