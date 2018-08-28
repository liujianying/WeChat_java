package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$11 implements a {
    final /* synthetic */ hq a;

    hq$11(hq hqVar) {
        this.a = hqVar;
    }

    public void a(GL10 gl10) {
        hq.b(this.a).nativeClearDownloadURLCache(hq.a(this.a));
    }
}
