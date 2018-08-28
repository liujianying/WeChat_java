package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.u.b.c {
    public String data;

    public c() {
        super("onDataPush");
    }

    c(int i) {
        super("onDataPush", i);
    }

    public final JSONObject tR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", bi.oV(this.data));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
