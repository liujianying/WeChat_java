package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.z.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$t implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$t(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$t(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        d dVar = this.pZJ.gcO;
        if (6 != this.pZJ.getIntent().getIntExtra("geta8key_scene", 0)) {
            return !bi.oW(str) && dVar != null && c.a(dVar) && c.b(str, dVar);
        } else {
            x.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
            return false;
        }
    }

    public final boolean Du(String str) {
        String stringExtra = this.pZJ.getIntent().getStringExtra("geta8key_username");
        return c.a(str, stringExtra, WebViewUI.b(this.pZJ, stringExtra), this.pZJ.gcO, WebViewUI.aN(this.pZJ), WebViewUI.b(this.pZJ), this.pZJ.hashCode());
    }
}
