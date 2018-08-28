package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class WebViewUI$33 implements c {
    final /* synthetic */ WebViewUI pZJ;
    final /* synthetic */ String val$url;

    WebViewUI$33(WebViewUI webViewUI, String str) {
        this.pZJ = webViewUI;
        this.val$url = str;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                if (WebViewUI.g(this.pZJ, this.val$url)) {
                    this.pZJ.mhH.loadUrl(this.val$url);
                    return;
                }
                x.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + this.val$url);
                WebViewUI.K(this.pZJ);
                return;
            case 1:
                a.a(this.pZJ, this.val$url, this.val$url);
                return;
            default:
                return;
        }
    }
}
