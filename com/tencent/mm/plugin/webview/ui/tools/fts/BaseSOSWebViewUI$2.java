package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Map;

class BaseSOSWebViewUI$2 implements Runnable {
    final /* synthetic */ Map prf;
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$2(BaseSOSWebViewUI baseSOSWebViewUI, Map map) {
        this.qdp = baseSOSWebViewUI;
        this.prf = map;
    }

    public final void run() {
        if (BaseSOSWebViewUI.o(this.qdp) != null) {
            BaseSOSWebViewUI.p(this.qdp).ap(this.prf);
        }
    }
}
