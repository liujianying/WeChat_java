package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$24 implements a {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ hq c;

    hq$24(hq hqVar, int i, int i2) {
        this.c = hqVar;
        this.a = i;
        this.b = i2;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeSetCompassPosition(hq.a(this.c), this.a, this.b);
    }
}
