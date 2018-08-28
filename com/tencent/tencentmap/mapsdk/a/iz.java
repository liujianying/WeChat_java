package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class iz {
    protected String a;
    private GeoPoint b;
    private Bitmap[] c;
    private float d = 0.5f;
    private float e = 0.5f;
    private float f = 1.0f;
    private boolean g = false;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private boolean n = false;
    private boolean o;
    private boolean p = true;

    public iz a(GeoPoint geoPoint) {
        this.b = geoPoint;
        return this;
    }

    public GeoPoint a() {
        return this.b;
    }

    public iz a(String str, Bitmap... bitmapArr) {
        this.a = str;
        this.c = bitmapArr;
        return this;
    }

    public iz a(boolean z) {
        this.n = z;
        return this;
    }

    public Bitmap[] b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public iz b(boolean z) {
        this.g = z;
        return this;
    }

    public boolean d() {
        return this.g;
    }

    public iz a(float f) {
        this.f = f;
        return this;
    }

    public float e() {
        return this.f;
    }

    public iz a(float f, float f2) {
        this.d = f;
        this.e = f2;
        return this;
    }

    public float f() {
        return this.d;
    }

    public float g() {
        return this.e;
    }

    public iz a(int i) {
        this.h = i;
        return this;
    }

    public int h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public iz c(boolean z) {
        this.o = z;
        return this;
    }

    public boolean j() {
        return this.o;
    }

    public int k() {
        return this.j;
    }

    public int l() {
        return this.k;
    }

    public iz b(int i) {
        this.l = i;
        return this;
    }

    public int m() {
        return this.l;
    }

    public iz d(boolean z) {
        this.m = z;
        return this;
    }

    public boolean n() {
        return this.m;
    }

    public boolean o() {
        return this.n;
    }

    public iz e(boolean z) {
        this.p = z;
        return this;
    }

    public boolean p() {
        return this.p;
    }
}
