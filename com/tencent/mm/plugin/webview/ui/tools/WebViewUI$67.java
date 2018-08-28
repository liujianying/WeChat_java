package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.snackbar.a.b;

class WebViewUI$67 implements b {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$67(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void aMj() {
        try {
            this.pZJ.gcO.favEditTag();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
        }
    }
}
