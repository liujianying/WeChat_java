package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$a implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$a(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$a(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://jump/");
    }

    public final boolean Du(String str) {
        if (this.pZJ.gcP.bVS().cgg()) {
            try {
                this.pZJ.gcO.be(str, this.pZJ.gcP.bVR().gu(7));
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
            }
        } else {
            x.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
        }
        return true;
    }
}
