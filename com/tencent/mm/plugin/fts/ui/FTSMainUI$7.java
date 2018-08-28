package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.sdk.platformtools.x;

class FTSMainUI$7 implements Runnable {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$7(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void run() {
        x.i("MicroMsg.FTS.FTSMainUI", " finish");
        FTSMainUI.c(this.jxp);
    }
}
