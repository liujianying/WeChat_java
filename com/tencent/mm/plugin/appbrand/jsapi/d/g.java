package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(p pVar, JSONObject jSONObject, int i) {
        h hVar = new h();
        if (a(hVar, jSONObject, pVar, i)) {
            try {
                int i2 = jSONObject.getInt("inputId");
                if (hVar.gLB != null && hVar.gLB.intValue() < 0) {
                    hVar.gLB = Integer.valueOf(0);
                }
                if (hVar.gLC != null && hVar.gLC.intValue() < 0) {
                    hVar.gLC = Integer.valueOf(0);
                }
                String optString = jSONObject.optString("data", null);
                if (optString != null) {
                    L(i2, optString);
                }
                c.runOnUiThread(new 1(this, i2, hVar, pVar, i));
            } catch (JSONException e) {
                pVar.E(i, f("fail:invalid data", null));
            }
        }
    }

    protected final boolean aiT() {
        return true;
    }
}
