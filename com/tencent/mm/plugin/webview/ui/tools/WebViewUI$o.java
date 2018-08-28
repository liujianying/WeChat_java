package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$o implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$o(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$o(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://gethtml/");
    }

    public final boolean Du(String str) {
        if (!bi.oW(str)) {
            x.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + str.substring(17));
            this.pZJ.bWp();
        }
        return false;
    }
}
