package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$6 implements Runnable {
    final /* synthetic */ String gvE;
    final /* synthetic */ int gvF;
    final /* synthetic */ int nmN;
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$6(BaseSOSWebViewUI baseSOSWebViewUI, int i, String str, int i2) {
        this.qdp = baseSOSWebViewUI;
        this.nmN = i;
        this.gvE = str;
        this.gvF = i2;
    }

    public final void run() {
        if (BaseSOSWebViewUI.x(this.qdp) != null) {
            BaseSOSWebViewUI.y(this.qdp).i(this.nmN, this.gvE, this.gvF);
        }
    }
}
