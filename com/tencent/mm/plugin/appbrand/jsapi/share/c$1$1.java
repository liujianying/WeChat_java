package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.share.c.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class c$1$1 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ SendAppMessageTask fYN;
    final /* synthetic */ int fYO;
    final /* synthetic */ 1 fYP;

    c$1$1(1 1, SendAppMessageTask sendAppMessageTask, String str, int i) {
        this.fYP = 1;
        this.fYN = sendAppMessageTask;
        this.bAd = str;
        this.fYO = i;
    }

    public final void run() {
        x.i("MicroMsg.JsApiShareAppMessage", "task callback");
        this.fYN.ahB();
        Map hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        try {
            if (!bi.cX(this.fYN.fZe)) {
                Iterator it = this.fYN.fZe.iterator();
                while (it.hasNext()) {
                    ShareInfo shareInfo = (ShareInfo) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("shareKey", shareInfo.dzR);
                    jSONObject.put("shareName", shareInfo.dFy);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
        }
        hashMap.put("shareInfos", jSONArray);
        this.fYP.fCl.E(this.fYP.doP, this.fYP.fYM.f("ok", hashMap));
        int i = 16;
        String str = this.bAd + ":";
        if (this.bAd.toLowerCase().endsWith("@chatroom")) {
            i = 15;
        }
        c.a(this.fYP.bAj, this.fYP.fYB, i, str, 1, this.fYO);
    }
}
