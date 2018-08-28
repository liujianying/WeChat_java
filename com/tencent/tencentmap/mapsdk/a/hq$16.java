package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$16 implements a {
    final /* synthetic */ hq a;

    hq$16(hq hqVar) {
        this.a = hqVar;
    }

    public void a(GL10 gl10) {
        hq.b(this.a).nativeHideTraffic(hq.a(this.a));
    }
}
