package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.10;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$23$51 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String qap;
    final /* synthetic */ int qaq;

    WebViewUI$23$51(23 23, String str, int i) {
        this.pZM = 23;
        this.qap = str;
        this.qaq = i;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            String str = this.qap;
            int i = this.qaq;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
                Map hashMap = new HashMap();
                hashMap.put("localId", str);
                hashMap.put("percent", Integer.valueOf(i));
                ah.A(new 10(dVar, a.a("onMediaFileUploadProgress", hashMap, dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
        }
    }
}
