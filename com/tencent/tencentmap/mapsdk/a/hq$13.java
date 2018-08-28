package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$13 implements a {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ hq c;

    hq$13(hq hqVar, int i, boolean z) {
        this.c = hqVar;
        this.a = i;
        this.b = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeSetMapMode(hq.a(this.c), this.a, this.b);
    }
}
