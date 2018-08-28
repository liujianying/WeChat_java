package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$4 implements Runnable {
    final /* synthetic */ int ekt;
    final /* synthetic */ FTSBaseWebViewUI qdI;
    final /* synthetic */ String qds;

    FTSBaseWebViewUI$4(FTSBaseWebViewUI fTSBaseWebViewUI, String str, int i) {
        this.qdI = fTSBaseWebViewUI;
        this.qds = str;
        this.ekt = i;
    }

    public final void run() {
        if (FTSBaseWebViewUI.w(this.qdI) != null) {
            FTSBaseWebViewUI.x(this.qdI).cJ(this.qds, this.ekt);
        }
    }
}
