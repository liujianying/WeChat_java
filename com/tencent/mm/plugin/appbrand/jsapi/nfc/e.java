package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        a(new 1(this, lVar, i));
    }

    static void a(l lVar, int i, String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[]{str});
        if (lVar != null) {
            lVar.E(i, str);
        }
    }
}
