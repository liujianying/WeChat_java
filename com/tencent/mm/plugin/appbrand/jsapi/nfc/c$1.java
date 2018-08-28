package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fWx;
    final /* synthetic */ c fWy;

    c$1(c cVar, l lVar, int i, JSONObject jSONObject) {
        this.fWy = cVar;
        this.fCl = lVar;
        this.doP = i;
        this.fWx = jSONObject;
    }

    public final void M(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            c cVar = this.fWy;
            l lVar = this.fCl;
            int i2 = this.doP;
            JSONObject jSONObject = this.fWx;
            Map hashMap2 = new HashMap();
            String optString = jSONObject.optString("data");
            if (bi.oW(optString)) {
                hashMap2.put("errCode", Integer.valueOf(13005));
                c.a(lVar, i2, cVar.f("fail", hashMap2));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", optString);
            HCEEventLogic.c(lVar.mAppId, 32, bundle);
            hashMap2.put("errCode", Integer.valueOf(0));
            lVar.E(i2, cVar.f("ok", hashMap2));
            return;
        }
        c.a(this.fCl, this.doP, this.fWy.f("fail: " + str, hashMap));
    }
}
