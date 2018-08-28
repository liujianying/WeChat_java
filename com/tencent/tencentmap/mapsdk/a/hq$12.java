package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$12 implements a {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ hq e;

    hq$12(hq hqVar, int i, int i2, int i3, int i4) {
        this.e = hqVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public void a(GL10 gl10) {
        hq.b(this.e).nativeSetViewport(hq.a(this.e), this.a, this.b, this.c, this.d);
    }
}
