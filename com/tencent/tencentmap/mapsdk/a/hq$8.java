package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$8 implements a {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ hq c;

    hq$8(hq hqVar, float f, float f2) {
        this.c = hqVar;
        this.a = f;
        this.b = f2;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeZoomIn(hq.a(this.c), this.a, this.b);
    }
}
