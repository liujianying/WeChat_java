package com.tencent.map.lib.gl.model;

public class d {
    private float a;
    private float b;
    private float c;

    public d(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        c();
    }

    public float[] a() {
        return new float[]{this.a, this.b, this.c};
    }

    public double b() {
        return Math.sqrt((double) (((this.a * this.a) + (this.b * this.b)) + (this.c * this.c)));
    }

    private void c() {
        double b = b();
        if (b != 0.0d) {
            this.a = (float) (((double) this.a) / b);
            this.b = (float) (((double) this.b) / b);
            this.c = (float) (((double) this.c) / b);
        }
    }

    public String toString() {
        return this.a + "," + this.b + "," + this.c;
    }
}
