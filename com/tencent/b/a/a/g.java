package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g {
    String bjM = null;
    String bvw = null;
    String bvx = "0";
    long bvy = 0;

    g() {
    }

    static g ch(String str) {
        g gVar = new g();
        if (s.ci(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.bjM = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.bvw = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.bvx = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.bvy = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
            }
        }
        return gVar;
    }

    final int a(g gVar) {
        if (gVar == null) {
            return 1;
        }
        if (s.cj(this.bvx) && s.cj(gVar.bvx)) {
            if (this.bvx.equals(gVar.bvx)) {
                return 0;
            }
            if (this.bvy < gVar.bvy) {
                return -1;
            }
            return 1;
        } else if (s.cj(this.bvx)) {
            return 1;
        } else {
            return -1;
        }
    }

    public final String toString() {
        return tN().toString();
    }

    private JSONObject tN() {
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.bjM);
            s.a(jSONObject, "mc", this.bvw);
            s.a(jSONObject, "mid", this.bvx);
            jSONObject.put("ts", this.bvy);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
