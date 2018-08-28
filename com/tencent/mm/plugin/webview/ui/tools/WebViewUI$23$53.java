package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.17;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$23$53 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ int fXT;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String qas;
    final /* synthetic */ String qat;
    final /* synthetic */ String qau;

    WebViewUI$23$53(23 23, String str, int i, String str2, int i2, String str3, String str4) {
        this.pZM = 23;
        this.qas = str;
        this.fXT = i;
        this.qat = str2;
        this.bFr = i2;
        this.dJG = str3;
        this.qau = str4;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            String str = this.qas;
            int i = this.fXT;
            String str2 = this.qat;
            int i2 = this.bFr;
            String str3 = this.dJG;
            String str4 = this.qau;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                hashMap.put("duration", Integer.valueOf(i));
                hashMap.put("src", str2);
                hashMap.put("errCode", Integer.valueOf(i2));
                hashMap.put("errMsg", str3);
                hashMap.put("srcId ", str4);
                ah.A(new 17(dVar, a.a("onBackgroundAudioStateChange", hashMap, dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
        }
    }
}
