package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;

class WebViewUI$s implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$s(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$s(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://manual_update/");
    }

    public final boolean Du(String str) {
        h.mEJ.a(405, 26, 1, true);
        WebViewUI.g(this.pZJ, 3);
        return true;
    }
}
