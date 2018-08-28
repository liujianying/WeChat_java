package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.29;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$29$1 implements b {
    final /* synthetic */ 29 qav;

    WebViewUI$29$1(29 29) {
        this.qav = 29;
    }

    public final void uf(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
        } else {
            WebViewUI.e(this.qav.pZJ, str);
        }
    }
}
