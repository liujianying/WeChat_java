package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.modeltools.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$32 implements a {
    final /* synthetic */ g qiK;
    final /* synthetic */ String qji;
    final /* synthetic */ i qjj;

    g$32(g gVar, String str, i iVar) {
        this.qiK = gVar;
        this.qji = str;
        this.qjj = iVar;
    }

    public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
        if (!bi.oV(str).equalsIgnoreCase(this.qji)) {
            x.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", new Object[]{this.qji, str});
        } else if (jSONObject == null) {
            x.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", new Object[]{str});
            MY(str);
        } else {
            Map hashMap = new HashMap(2);
            hashMap.put("cardType", str);
            hashMap.put("cardInfo", jSONObject);
            g.a(this.qiK, this.qjj, "scanLicence:ok", hashMap);
        }
    }

    public final void QK(String str) {
        if (bi.oV(str).equals(this.qji)) {
            Map hashMap = new HashMap(1);
            hashMap.put("cardType", str);
            g.a(this.qiK, this.qjj, "scanLicence:cancel", hashMap);
        }
    }

    public final void MY(String str) {
        if (bi.oV(str).equals(this.qji)) {
            Map hashMap = new HashMap(1);
            hashMap.put("cardType", str);
            g.a(this.qiK, this.qjj, "scanLicence:fail", hashMap);
        }
    }
}
