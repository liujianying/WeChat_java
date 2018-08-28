package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.share.d.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class d$1$1 implements Runnable {
    final /* synthetic */ SendAppMessageTask fYN;
    final /* synthetic */ 1 fYR;

    d$1$1(1 1, SendAppMessageTask sendAppMessageTask) {
        this.fYR = 1;
        this.fYN = sendAppMessageTask;
    }

    public final void run() {
        x.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
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
            x.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(e));
        }
        hashMap.put("shareInfos", jSONArray);
        this.fYR.fCl.E(this.fYR.doP, this.fYR.fYQ.f("ok", hashMap));
    }
}
