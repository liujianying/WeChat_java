package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.opengles.GL10;

class hq$1 implements hv$a {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ hq c;

    hq$1(hq hqVar, int i, int i2) {
        this.c = hqVar;
        this.a = i;
        this.b = i2;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeDeletePolygon(hq.a(this.c), this.a, this.b);
    }
}
