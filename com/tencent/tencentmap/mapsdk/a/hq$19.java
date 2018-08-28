package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.hv.a;
import javax.microedition.khronos.opengles.GL10;

class hq$19 implements a {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ hq c;

    hq$19(hq hqVar, String str, byte[] bArr) {
        this.c = hqVar;
        this.a = str;
        this.b = bArr;
    }

    public void a(GL10 gl10) {
        hq.b(this.c).nativeWriteMapDataBlock(hq.a(this.c), this.a, this.b);
    }
}
