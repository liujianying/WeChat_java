package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$3 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$3(FTSBaseWebViewUI fTSBaseWebViewUI, String str) {
        this.qdI = fTSBaseWebViewUI;
        this.gvE = str;
    }

    public final void run() {
        if (FTSBaseWebViewUI.u(this.qdI) != null) {
            FTSBaseWebViewUI.v(this.qdI).RH(this.gvE);
        }
    }
}
