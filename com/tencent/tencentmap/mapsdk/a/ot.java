package com.tencent.tencentmap.mapsdk.a;

public class ot {
    private ox a = new ox(39.984253d, 116.307439d);
    private double b = 1.0d;
    private float c = 1.0f;
    private int d = -16777216;
    private int e = 0;
    private int f = 0;
    private boolean g = true;

    public ot a(ox oxVar) {
        this.a = oxVar;
        return this;
    }

    public ot a(double d) {
        this.b = d;
        return this;
    }

    public ot a(float f) {
        if (f < 0.0f) {
            this.c = 1.0f;
        } else {
            this.c = f;
        }
        return this;
    }

    public ot a(int i) {
        this.d = i;
        return this;
    }

    public ot b(int i) {
        this.e = i;
        return this;
    }

    public ot c(int i) {
        this.f = i;
        return this;
    }

    public ot a(boolean z) {
        this.g = z;
        return this;
    }

    public ox a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }
}
