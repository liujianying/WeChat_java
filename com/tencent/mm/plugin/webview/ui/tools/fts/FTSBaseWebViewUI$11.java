package com.tencent.mm.plugin.webview.ui.tools.fts;

class FTSBaseWebViewUI$11 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ String pPl;
    final /* synthetic */ FTSBaseWebViewUI qdI;
    final /* synthetic */ boolean qdr;

    FTSBaseWebViewUI$11(FTSBaseWebViewUI fTSBaseWebViewUI, String str, boolean z, String str2) {
        this.qdI = fTSBaseWebViewUI;
        this.gvE = str;
        this.qdr = z;
        this.pPl = str2;
    }

    public final void run() {
        if (FTSBaseWebViewUI.m(this.qdI) != null) {
            FTSBaseWebViewUI.n(this.qdI).d(this.gvE, this.qdr, this.pPl);
        }
    }
}
