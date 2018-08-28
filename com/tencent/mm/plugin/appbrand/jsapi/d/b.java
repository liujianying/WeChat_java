package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        b(pVar, jSONObject, i);
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        b(lVar, jSONObject, i);
    }

    private void b(c cVar, JSONObject jSONObject, int i) {
        Integer num = null;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException e) {
        }
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 1(this, cVar, num, i));
    }
}
