package com.tencent.tencentmap.mapsdk.a;

public class ic$a implements Cloneable {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final float e = (4.0f / ((float) (1 << (c - d))));
    private static final boolean f;
    private float g = e;
    private float h = 4.0f;
    private int i = d;
    private int j = a;
    private float k;
    private int l;

    static {
        int i;
        int i2 = 20;
        boolean b = jc.b();
        f = b;
        a = b ? 19 : 21;
        if (f) {
            i = 20;
        } else {
            i = 22;
        }
        b = i;
        if (!f) {
            i2 = 22;
        }
        c = i2;
        if (f) {
            i = 3;
        } else {
            i = 4;
        }
        d = i;
    }

    public void a(float f) {
        this.k = f;
    }

    public void a(int i, float f) {
        this.k = f;
        this.l = i;
    }

    void a(ic$a ic_a) {
        this.g = ic_a.g;
        this.h = ic_a.h;
        this.i = ic_a.i;
        this.j = ic_a.j;
        this.k = ic_a.k;
        this.l = ic_a.l;
    }

    void b(float f) {
        ic$a ic_a = new ic$a();
        this.i = ic_a.b();
        this.g = f / ic_a.c();
    }

    float a(int i) {
        return 1.9073486E-6f * ((float) (1 << (i - 1)));
    }

    float a() {
        return this.k;
    }

    int b() {
        return this.l;
    }

    float c() {
        return this.k / a(this.l);
    }

    int d() {
        return this.i;
    }

    int e() {
        return this.j;
    }

    int f() {
        return b;
    }

    float g() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ic$a)) {
            return false;
        }
        ic$a ic_a = (ic$a) obj;
        if (this.k == ic_a.k && this.l == ic_a.l) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "scale:" + this.k + ", scaleLevel:" + this.l;
    }

    public Object clone() {
        return super.clone();
    }
}
