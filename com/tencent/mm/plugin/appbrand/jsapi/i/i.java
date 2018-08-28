package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", lVar.mAppId);
            a.fWH.a(c, jSONObject, new 1(this, lVar, i));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiVerifyPaymentPassword", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}
