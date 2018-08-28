package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.f.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.54;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$4 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$4(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void bVV() {
        x.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
        if (this.pZJ.pNV != null) {
            d dVar = this.pZJ.pNV;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                ah.A(new 54(dVar, d.RI(i.a.a("onPullDownRefresh", null, dVar.qhs, dVar.qht))));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
        }
    }
}
