package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$9 implements Runnable {
    final /* synthetic */ int ekt;
    final /* synthetic */ BaseSOSWebViewUI qdp;
    final /* synthetic */ String qds;

    BaseSOSWebViewUI$9(BaseSOSWebViewUI baseSOSWebViewUI, String str, int i) {
        this.qdp = baseSOSWebViewUI;
        this.qds = str;
        this.ekt = i;
    }

    public final void run() {
        if (BaseSOSWebViewUI.D(this.qdp) != null) {
            BaseSOSWebViewUI.E(this.qdp).cJ(this.qds, this.ekt);
        }
    }
}
