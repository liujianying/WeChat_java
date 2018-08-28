package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$5 implements Runnable {
    final /* synthetic */ String fET;
    final /* synthetic */ int oCo;
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$5(BaseSOSWebViewUI baseSOSWebViewUI, int i, String str) {
        this.qdp = baseSOSWebViewUI;
        this.oCo = i;
        this.fET = str;
    }

    public final void run() {
        if (BaseSOSWebViewUI.v(this.qdp) != null) {
            BaseSOSWebViewUI.w(this.qdp).aV(this.oCo, this.fET);
        }
    }
}
