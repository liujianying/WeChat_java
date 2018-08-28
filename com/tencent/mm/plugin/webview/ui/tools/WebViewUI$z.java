package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

class WebViewUI$z implements b {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$z(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$z(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final boolean Dt(String str) {
        if (bi.oW(str)) {
            return false;
        }
        return s.fj(str, "weixin://private/gethtml/");
    }

    public final boolean Du(String str) {
        try {
            String decode = URLDecoder.decode(str.substring(25));
            Bundle bundle = new Bundle();
            bundle.putString("nowUrl", WebViewUI.aO(this.pZJ));
            bundle.putString("tweetid", bi.oV(this.pZJ.getIntent().getStringExtra("tweetid")));
            bundle.putString("htmlData", decode);
            bundle.putInt("type", this.pZJ.getIntent().getIntExtra("type", 0));
            this.pZJ.gcO.a(3, bundle, this.pZJ.hashCode());
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
            return false;
        }
    }
}
