package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import javax.microedition.khronos.opengles.GL10;

class hq$25 implements hv$a {
    final /* synthetic */ Rect a;
    final /* synthetic */ Rect b;
    final /* synthetic */ boolean c;
    final /* synthetic */ hq d;

    hq$25(hq hqVar, Rect rect, Rect rect2, boolean z) {
        this.d = hqVar;
        this.a = rect;
        this.b = rect2;
        this.c = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.d).nativeZoomToSpan(hq.a(this.d), this.a, this.b, this.c);
    }
}
