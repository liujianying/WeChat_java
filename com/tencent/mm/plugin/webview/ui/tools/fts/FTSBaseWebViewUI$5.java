package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$5 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$5(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.y(this.qdI) != null) {
            FTSBaseWebViewUI.z(this.qdI).a(this.qdI.getTotalQuery(), this.qdI.getInEditTextQuery(), this.qdI.bXp(), 1);
        }
    }
}
