package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.opengles.GL10;

class hq$22 implements hv$a {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ double c;
    final /* synthetic */ double d;
    final /* synthetic */ float e;
    final /* synthetic */ float f;
    final /* synthetic */ float g;
    final /* synthetic */ float h;
    final /* synthetic */ float i;
    final /* synthetic */ float j;
    final /* synthetic */ boolean k;
    final /* synthetic */ boolean l;
    final /* synthetic */ boolean m;
    final /* synthetic */ boolean n;
    final /* synthetic */ int o;
    final /* synthetic */ hq p;

    hq$22(hq hqVar, int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.p = hqVar;
        this.a = i;
        this.b = str;
        this.c = d;
        this.d = d2;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = f5;
        this.j = f6;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = z4;
        this.o = i2;
    }

    public void a(GL10 gl10) {
        hq.b(this.p).nativeUpdateMarkerInfo(hq.a(this.p), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
}
