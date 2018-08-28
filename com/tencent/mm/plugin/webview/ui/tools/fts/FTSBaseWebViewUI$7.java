package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$7 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$7(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.a(this.qdI) != null) {
            FTSBaseWebViewUI.b(this.qdI).a(this.qdI.getTotalQuery(), this.qdI.getInEditTextQuery(), this.qdI.bXp(), 0);
        }
    }
}
