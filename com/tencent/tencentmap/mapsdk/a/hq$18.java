package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.opengles.GL10;

class hq$18 implements hv$a {
    final /* synthetic */ int a;
    final /* synthetic */ int[] b;
    final /* synthetic */ hq c;

    hq$18(hq hqVar, int i, int[] iArr) {
        this.c = hqVar;
        this.a = i;
        this.b = iArr;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeSetTurnArrowStyle(hq.a(this.c), (long) this.a, this.b[0], this.b[1]);
    }
}
