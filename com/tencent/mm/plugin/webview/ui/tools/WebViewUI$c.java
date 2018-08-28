package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$c implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$c(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$c(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://webview/close/");
    }

    public final boolean Du(String str) {
        if (this.pZJ.gcP.bVR().gu(17)) {
            this.pZJ.finish();
        } else {
            x.e("MicroMsg.WebViewUI", "close window permission fail");
        }
        return true;
    }
}
