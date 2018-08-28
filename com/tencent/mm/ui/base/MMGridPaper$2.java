package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class MMGridPaper$2 implements Runnable {
    final /* synthetic */ MMGridPaper tvg;

    MMGridPaper$2(MMGridPaper mMGridPaper) {
        this.tvg = mMGridPaper;
    }

    public final void run() {
        x.w("MicroMsg.MMGridPaper", "post do setDotView");
        MMGridPaper.a(this.tvg);
    }
}
