package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$15 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$15(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.g(this.qdp) != null) {
            BaseSOSWebViewUI.h(this.qdp).a(this.qdp.getTotalQuery(), this.qdp.getInEditTextQuery(), this.qdp.bXp());
        }
    }
}
