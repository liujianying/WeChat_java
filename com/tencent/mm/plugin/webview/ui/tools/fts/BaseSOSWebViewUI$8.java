package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$8 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$8(BaseSOSWebViewUI baseSOSWebViewUI, String str) {
        this.qdp = baseSOSWebViewUI;
        this.gvE = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.B(this.qdp) != null) {
            BaseSOSWebViewUI.C(this.qdp).RH(this.gvE);
        }
    }
}
