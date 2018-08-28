package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        p d = d(lVar);
        if (d != null) {
            try {
                Integer valueOf;
                String string = jSONObject.getString("value");
                try {
                    valueOf = Integer.valueOf(jSONObject.getInt("cursor"));
                } catch (Exception e) {
                    valueOf = null;
                }
                m.a(d, string, valueOf);
                lVar.E(i, f("ok", null));
            } catch (Exception e2) {
                lVar.E(i, f("fail:invalid data", null));
            }
        }
    }
}
