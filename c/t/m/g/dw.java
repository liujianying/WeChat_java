package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

final class dw {
    public String a;
    public String b;
    public int c;

    dw() {
    }

    public dw(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("bid");
            this.b = jSONObject.getString("floor");
            this.c = jSONObject.getInt("type");
        } catch (JSONException e) {
            throw e;
        }
    }
}
