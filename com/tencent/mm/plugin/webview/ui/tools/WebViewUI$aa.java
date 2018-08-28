package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$aa implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$aa(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$aa(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://viewimage/");
    }

    public final boolean Du(String str) {
        try {
            if (this.pZJ.gcO.isSDCardAvailable()) {
                WebViewUI.s(this.pZJ, str.substring(19));
                x.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.aO(this.pZJ));
                s.a(this.pZJ.mhH, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.aP(this.pZJ));
                return true;
            }
            this.pZJ.gcO.a(2, null, this.pZJ.hashCode());
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
            return false;
        }
    }
}
