package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Map;

class FTSBaseWebViewUI$10 implements Runnable {
    final /* synthetic */ Map prf;
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$10(FTSBaseWebViewUI fTSBaseWebViewUI, Map map) {
        this.qdI = fTSBaseWebViewUI;
        this.prf = map;
    }

    public final void run() {
        if (FTSBaseWebViewUI.k(this.qdI) != null) {
            FTSBaseWebViewUI.l(this.qdI).ap(this.prf);
        }
    }
}
