package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import com.tencent.mm.pluginsdk.model.app.g;

class WebViewUI$58 implements Runnable {
    final /* synthetic */ Uri hdW;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$58(WebViewUI webViewUI, Uri uri) {
        this.pZJ = webViewUI;
        this.hdW = uri;
    }

    public final void run() {
        g.f(this.pZJ, this.hdW);
    }
}
