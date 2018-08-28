package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.plugin.downloader.c.a;

class d$1 implements Runnable {
    final /* synthetic */ a ibG;
    final /* synthetic */ long ibH;
    final /* synthetic */ boolean ibL;
    final /* synthetic */ int ibW;
    final /* synthetic */ d ibX;
    final /* synthetic */ Context val$context;

    d$1(d dVar, a aVar, int i, Context context, long j, boolean z) {
        this.ibX = dVar;
        this.ibG = aVar;
        this.ibW = i;
        this.val$context = context;
        this.ibH = j;
        this.ibL = z;
    }

    public final void run() {
        new ad(this.ibG.field_packageName, this.ibW).a(g.Eh().dpP.dJs, new 1(this));
    }
}
