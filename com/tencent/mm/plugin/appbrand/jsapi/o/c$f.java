package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.mm.plugin.appbrand.q.f;
import org.json.JSONException;
import org.json.JSONObject;

public class c$f {
    public int id;
    public float x;
    public float y;

    public c$f(int i, float f, float f2) {
        this.id = i;
        this.x = f;
        this.y = f2;
    }

    public final void a(int i, float f, float f2) {
        this.id = i;
        this.x = f;
        this.y = f2;
    }

    public final JSONObject tR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("x", (double) f.ad(this.x));
            jSONObject.put("y", (double) f.ad(this.y));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return tR().toString();
    }
}
