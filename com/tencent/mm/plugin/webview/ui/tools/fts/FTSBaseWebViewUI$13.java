package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$13 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ int gvF;
    final /* synthetic */ int nmN;
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$13(FTSBaseWebViewUI fTSBaseWebViewUI, int i, String str, int i2) {
        this.qdI = fTSBaseWebViewUI;
        this.nmN = i;
        this.gvE = str;
        this.gvF = i2;
    }

    public final void run() {
        if (FTSBaseWebViewUI.q(this.qdI) != null) {
            FTSBaseWebViewUI.r(this.qdI).i(this.nmN, this.gvE, this.gvF);
        }
    }
}
