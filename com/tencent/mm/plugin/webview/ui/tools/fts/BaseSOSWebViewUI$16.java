package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$16 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$16(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.i(this.qdp) != null) {
            BaseSOSWebViewUI.j(this.qdp).a(this.qdp.getTotalQuery(), this.qdp.getInEditTextQuery(), this.qdp.bXp());
        }
    }
}
