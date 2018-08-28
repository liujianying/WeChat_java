package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements Runnable {
    final /* synthetic */ Bitmap iOx;
    final /* synthetic */ String iOy;

    o$1(Bitmap bitmap, String str) {
        this.iOx = bitmap;
        this.iOy = str;
    }

    public final void run() {
        long VG = bi.VG();
        o.b(this.iOx, this.iOy);
        x.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", Long.valueOf(bi.bI(VG)));
    }
}
