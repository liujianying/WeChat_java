package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.3;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

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
            a aVar = a.fWH;
            3 3 = new 3(aVar, new 1(this, lVar, i));
            g gVar = new g(jSONObject);
            gVar.bVZ = 4;
            h.b(c, gVar, aVar.hashCode() & 65535, 3);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiBindPaymentCard", e.getMessage());
            lVar.E(i, f("fail", null));
        }
    }
}
