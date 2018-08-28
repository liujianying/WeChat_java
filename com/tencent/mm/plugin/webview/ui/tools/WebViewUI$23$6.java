package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.19;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$23$6 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$6(23 23, int i) {
        this.pZM = 23;
        this.bFr = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            int i = this.bFr;
            if (dVar.qhq) {
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                ah.A(new 19(dVar, a.a("onNfcTouch", hashMap, dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
        }
    }
}
