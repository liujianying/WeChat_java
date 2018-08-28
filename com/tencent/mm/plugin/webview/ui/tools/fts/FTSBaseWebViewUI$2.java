package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$2 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$2(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.s(this.qdI) != null) {
            FTSBaseWebViewUI.t(this.qdI).a(this.qdI.getTotalQuery(), this.qdI.getInEditTextQuery(), this.qdI.bXp(), 0);
        }
    }
}
