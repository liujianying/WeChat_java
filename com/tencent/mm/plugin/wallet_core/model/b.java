package com.tencent.mm.plugin.wallet_core.model;

import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public double mxI = 0.0d;
    public int oZR = 0;
    public int oZS = 0;
    public int oZT = 0;
    public double oZU = 0.0d;
    public String plA;
    public LinkedList<b> plB;
    public String plC;
    public String plD;
    public a plE;

    public static class a {
        public String plF = "";
        public c[] plG = new c[0];
    }

    public static a ad(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                aVar.plF = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    aVar.plG = new c[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        c cVar = new c();
                        cVar.title = jSONObject2.optString("title", "");
                        cVar.desc = jSONObject2.optString("desc", "");
                        cVar.huW = jSONObject2.optString("logo_url", "");
                        cVar.paB = jSONObject2.optInt("jump_type");
                        cVar.hwI = jSONObject2.optString("jump_url", "");
                        aVar.plG[i] = cVar;
                    }
                }
            } catch (JSONException e) {
            }
        }
        return aVar;
    }
}
