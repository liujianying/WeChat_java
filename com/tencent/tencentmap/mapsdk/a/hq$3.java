package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$3 implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ hq b;

    hq$3(hq hqVar, boolean z) {
        this.b = hqVar;
        this.a = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.b).nativeSetCompassMarkerHidden(hq.a(this.b), this.a);
    }
}
