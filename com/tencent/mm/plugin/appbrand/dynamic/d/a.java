package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.b$a;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    private static String fvI = "com.tencent.mm:tools";

    public a() {
        super(d.NAME, 419);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b$a<JSONObject> b_a) {
        b Da = aVar.Da();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", Da.getString("__page_app_id", ""));
            bundle.putString("widgetId", Da.getString("__page_view_id", ""));
            XIPCInvoker.a(Da.getString("__process_name", fvI), bundle, b.class, new 1(this));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", new Object[]{e.getMessage()});
        }
    }
}
