package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.58;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class WebViewUI$23$19 implements Runnable {
    final /* synthetic */ 23 pZM;
    final /* synthetic */ JSONArray qab;

    WebViewUI$23$19(23 23, JSONArray jSONArray) {
        this.pZM = 23;
        this.qab = jSONArray;
    }

    public final void run() {
        if (this.pZM.pZJ.pNV != null) {
            d dVar = this.pZM.pZJ.pNV;
            JSONArray jSONArray = this.qab;
            if (jSONArray == null) {
                x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                return;
            }
            x.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
            Map hashMap = new HashMap();
            hashMap.put("msgs", jSONArray);
            ah.A(new 58(dVar, a.a("onGetMsgProofItems", hashMap, dVar.qhs, dVar.qht)));
        }
    }
}
