package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fts.c.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$b implements Runnable {
    private String bVd;
    private String fwS;
    private int height;
    final /* synthetic */ c joV;
    private boolean joY;
    private c joZ;
    private String url;
    private int width;

    public c$b(c cVar, String str, String str2, String str3, boolean z, int i, int i2, c cVar2) {
        this.joV = cVar;
        this.fwS = str;
        this.url = str2;
        this.bVd = str3;
        this.joZ = cVar2;
        this.joY = z;
        this.width = i;
        this.height = i2;
    }

    public final void run() {
        x.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", new Object[]{this.fwS});
        if (bi.oW(this.bVd)) {
            this.bVd = c.Cl(this.fwS);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap Q = c.Q(this.bVd, this.width, this.height);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (Q != null) {
            x.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[]{this.url, this.bVd, Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            c.a(this.joV, this.fwS, this.bVd, Q);
            this.joZ.au(this.fwS, true);
            return;
        }
        Bitmap a = c.a(this.joV, this.url, this.joY, this.width, this.height);
        long currentTimeMillis3 = System.currentTimeMillis();
        x.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[]{this.url, this.bVd, Long.valueOf(currentTimeMillis3 - currentTimeMillis2)});
        if (a != null) {
            c.a(this.joV, this.fwS, this.bVd, a);
            this.joZ.au(this.fwS, true);
            return;
        }
        this.joZ.au(this.fwS, false);
    }
}
