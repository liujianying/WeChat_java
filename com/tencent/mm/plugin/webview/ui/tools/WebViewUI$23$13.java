package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$23$13 implements Runnable {
    final /* synthetic */ String its;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZP;
    final /* synthetic */ byte[] pZT;

    WebViewUI$23$13(23 23, String str, byte[] bArr, String str2) {
        this.pZM = 23;
        this.pZP = str;
        this.pZT = bArr;
        this.its = str2;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            String str = this.pZP;
            byte[] bArr = this.pZT;
            String str2 = this.its;
            if (dVar.qhq) {
                x.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[]{str, str2});
                if (bi.oW(str) || bi.oW(str2) || bArr == null) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("deviceId", str);
                hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                ah.A(new 3(dVar, a.a("onReceiveDataFromWXDevice", hashMap, dVar.qhs, dVar.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
        }
    }
}
