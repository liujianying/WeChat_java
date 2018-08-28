package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.d;

class WebViewUI$40 implements Runnable {
    final /* synthetic */ d eRB;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$40(WebViewUI webViewUI, d dVar) {
        this.pZJ = webViewUI;
        this.eRB = dVar;
    }

    public final void run() {
        if (this.pZJ.isFinishing() || this.pZJ.pZc) {
            x.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
        } else {
            this.eRB.bXO();
        }
    }
}
