package com.tencent.mm.booter;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.e;

class o$1 implements Runnable {
    final /* synthetic */ int cXz;

    o$1(int i) {
        this.cXz = i;
    }

    public final void run() {
        h.mEJ.k(10675, this.cXz + "," + e.bxk);
    }
}
