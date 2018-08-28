package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ Bitmap das;
    final /* synthetic */ String dat;
    final /* synthetic */ g dau;

    public g$1(g gVar, Bitmap bitmap, String str) {
        this.dau = gVar;
        this.das = bitmap;
        this.dat = str;
    }

    public final void run() {
        try {
            c.a(this.das, 50, CompressFormat.PNG, this.dat, true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
        }
    }
}
