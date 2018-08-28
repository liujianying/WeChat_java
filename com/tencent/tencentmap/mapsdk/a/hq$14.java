package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$14 implements a {
    final /* synthetic */ hq a;

    hq$14(hq hqVar) {
        this.a = hqVar;
    }

    public void a(GL10 gl10) {
        hq.b(this.a).nativeShowTraffic(hq.a(this.a));
    }
}
