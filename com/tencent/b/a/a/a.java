package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String bvd = "ts";
    public static String bve = "times";
    public static String bvf = "mfreq";
    public static String bvg = "mdays";
    long buZ = 0;
    int bva = 0;
    int bvb = 100;
    int bvc = 3;

    a() {
    }

    a(String str) {
        if (s.ci(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(bvd)) {
                    this.buZ = jSONObject.getLong(bvd);
                }
                if (!jSONObject.isNull(bvf)) {
                    this.bvb = jSONObject.getInt(bvf);
                }
                if (!jSONObject.isNull(bve)) {
                    this.bva = jSONObject.getInt(bve);
                }
                if (!jSONObject.isNull(bvg)) {
                    this.bvc = jSONObject.getInt(bvg);
                }
            } catch (JSONException e) {
            }
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bvd, this.buZ);
            jSONObject.put(bve, this.bva);
            jSONObject.put(bvf, this.bvb);
            jSONObject.put(bvg, this.bvc);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
