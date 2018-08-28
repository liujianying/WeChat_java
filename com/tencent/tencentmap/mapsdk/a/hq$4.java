package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$4 implements a {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ boolean c;
    final /* synthetic */ hq d;

    hq$4(hq hqVar, float f, float f2, boolean z) {
        this.d = hqVar;
        this.a = f;
        this.b = f2;
        this.c = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.d).nativeMoveBy(hq.a(this.d), this.a, this.b, this.c);
    }
}
