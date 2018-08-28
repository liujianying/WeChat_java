package com.tencent.mm.plugin.webview.ui.tools.fts;

class BaseSOSWebViewUI$7 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$7(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.z(this.qdp) != null) {
            BaseSOSWebViewUI.A(this.qdp).a(this.qdp.getTotalQuery(), this.qdp.getInEditTextQuery(), this.qdp.bXp());
        }
    }
}
