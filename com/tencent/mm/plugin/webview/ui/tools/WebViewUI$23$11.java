package com.tencent.mm.plugin.webview.ui.tools;

import android.util.Base64;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.a.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class WebViewUI$23$11 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZP;
    final /* synthetic */ byte[] pZQ;
    final /* synthetic */ boolean pZR;
    final /* synthetic */ boolean pZS;

    WebViewUI$23$11(23 23, String str, byte[] bArr, boolean z, boolean z2) {
        this.pZM = 23;
        this.pZP = str;
        this.pZQ = bArr;
        this.pZR = z;
        this.pZS = z2;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            String str = this.pZP;
            byte[] bArr = this.pZQ;
            boolean z = this.pZR;
            boolean z2 = this.pZS;
            if (dVar.qhq) {
                String str2 = "MicroMsg.JsApiHandler";
                String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                x.i(str2, str3, objArr);
                if (bi.oW(str)) {
                    x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceId", str);
                    b.bXc();
                    if (b.be(bArr) || (bArr != null && z2)) {
                        jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                    }
                    jSONArray.put(jSONObject2);
                    jSONObject.put("devices", jSONArray);
                    if (z) {
                        jSONObject.put("isCompleted", "1");
                    } else {
                        jSONObject.put("isCompleted", "0");
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
                }
                try {
                    x.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[]{a.a("onScanWXDeviceResult", jSONObject, dVar.qhs, dVar.qht)});
                    dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                } catch (Exception e2) {
                    x.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e2.getMessage()});
                }
                if (!z2) {
                    b.bXc().qcR = bArr;
                    return;
                }
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
            return;
        }
        x.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[]{this.pZM.pZJ.pNV, this.pZM.pZJ.gcP});
    }
}
