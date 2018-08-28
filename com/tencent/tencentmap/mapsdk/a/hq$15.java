package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$15 implements a {
    final /* synthetic */ String a;
    final /* synthetic */ hq b;

    hq$15(hq hqVar, String str) {
        this.b = hqVar;
        this.a = str;
    }

    public void a(GL10 gl10) {
        hq.b(this.b).nativeSetServerHost(hq.a(this.b), this.a);
    }
}
