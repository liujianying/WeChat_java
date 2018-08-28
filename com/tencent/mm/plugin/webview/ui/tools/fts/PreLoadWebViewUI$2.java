package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.sdk.platformtools.x;

class PreLoadWebViewUI$2 implements Runnable {
    final /* synthetic */ PreLoadWebViewUI qeS;

    PreLoadWebViewUI$2(PreLoadWebViewUI preLoadWebViewUI) {
        this.qeS = preLoadWebViewUI;
    }

    public final void run() {
        try {
            PreLoadWebViewUI.b(this.qeS).await();
        } catch (Throwable e) {
            x.printErrStackTrace("PreLoadWebViewUI", e, "", new Object[0]);
        }
        if (PreLoadWebViewUI.c(this.qeS)) {
            x.i("PreLoadWebViewUI", "send onUiInit to webview");
            this.qeS.bXr();
            PreLoadWebViewUI.d(this.qeS).am(this.qeS.bXB());
        }
    }
}
