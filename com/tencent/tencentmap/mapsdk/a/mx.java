package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;

public class mx {
    protected float J = 1.0f;
    protected int K = Color.argb(17, 0, 163, 255);
    protected int L = Color.argb(255, 0, 163, 255);
    protected float M = 0.0f;
    protected boolean N = true;
    protected boolean O = false;

    public void a_(boolean z) {
        this.N = z;
    }

    public float w() {
        return this.M;
    }

    public void d(float f) {
        this.J = f;
        this.O = true;
    }

    public void b(int i) {
        this.L = i;
        this.O = true;
    }

    public void c(int i) {
        this.K = i;
        this.O = true;
    }

    public void c(float f) {
        this.M = f;
        this.O = true;
    }
}
