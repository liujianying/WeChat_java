package com.tencent.mm.plugin.fts.ui;

class FTSMainUI$2 implements Runnable {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$2(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void run() {
        if (FTSMainUI.k(this.jxp) != null) {
            FTSMainUI.k(this.jxp).dismiss();
            FTSMainUI.j(this.jxp);
        }
    }
}
