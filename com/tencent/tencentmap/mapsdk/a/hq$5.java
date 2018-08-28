package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.opengles.GL10;

class hq$5 implements hv$a {
    final /* synthetic */ boolean a;
    final /* synthetic */ hq b;

    hq$5(hq hqVar, boolean z) {
        this.b = hqVar;
        this.a = z;
    }

    public void a(GL10 gl10) {
        hq.b(this.b).nativeSetSatelliteEnabled(hq.a(this.b), this.a);
    }
}
