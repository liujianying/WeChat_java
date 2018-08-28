package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$8 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$8(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.c(this.qdI) != null) {
            FTSBaseWebViewUI.d(this.qdI).a(this.qdI.getTotalQuery(), this.qdI.getInEditTextQuery(), this.qdI.bXp(), 0);
        }
    }
}
