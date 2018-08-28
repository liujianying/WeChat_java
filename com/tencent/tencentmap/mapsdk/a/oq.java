package com.tencent.tencentmap.mapsdk.a;

import android.graphics.drawable.Drawable;
import android.view.View;

public class oq {
    private pa a;
    private String b;
    private ox c;
    private int d = 0;
    private int e = 0;
    private float f = 0.5f;
    private float g = 0.5f;
    private int h = 0;
    private View i;
    private Drawable[] j = null;
    private boolean k = false;

    public oq a(pa paVar) {
        this.a = paVar;
        a(paVar.i());
        a(paVar.u(), paVar.v());
        return this;
    }

    public pa a() {
        return this.a;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public oq a(float f, float f2) {
        this.f = f;
        this.g = f2;
        return this;
    }

    public float d() {
        return this.f;
    }

    public float e() {
        return this.g;
    }

    public oq a(String str) {
        this.b = str;
        return this;
    }

    public String f() {
        return this.b;
    }

    public oq a(ox oxVar) {
        this.c = oxVar;
        return this;
    }

    public ox g() {
        return this.c;
    }

    public int h() {
        return this.h;
    }

    public View i() {
        return this.i;
    }

    public Drawable[] j() {
        return this.j;
    }

    public oq a(boolean z) {
        this.k = z;
        return this;
    }

    public boolean k() {
        return this.k;
    }
}
