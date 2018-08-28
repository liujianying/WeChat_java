package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.fts.c.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$d implements Runnable {
    final /* synthetic */ c joV;
    private a jpa;

    public c$d(c cVar, a aVar) {
        this.joV = cVar;
        this.jpa = aVar;
    }

    public final void run() {
        x.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
        try {
            if (!new File(this.jpa.bVd).exists()) {
                if (this.jpa.bitmap == null || this.jpa.bitmap.isRecycled()) {
                    x.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                c.a(this.jpa.bitmap, 100, CompressFormat.PNG, this.jpa.bVd, false);
                x.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e, "", new Object[0]);
        }
    }
}
