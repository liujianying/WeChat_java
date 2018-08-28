package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$b implements b {
    final /* synthetic */ WebViewUI pZJ;
    public final String qaE;

    private WebViewUI$b(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
        this.qaE = "weixin://addfriend/";
    }

    /* synthetic */ WebViewUI$b(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://addfriend/");
    }

    public final boolean Du(String str) {
        if (this.pZJ.gcP.bVR().gu(5)) {
            String substring = str.substring(19);
            if (bi.oW(substring)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_webview", true);
            bundle.putString("userName", substring);
            try {
                this.pZJ.gcO.a(8, bundle, this.pZJ.hashCode());
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                return true;
            }
        }
        x.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
        return true;
    }
}
