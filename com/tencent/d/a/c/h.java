package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public String onE = "";
    public String signature = "";
    public int uid = -1;
    private long vlB = -1;
    private String vlC = "";
    public String vlD = "";

    public final String toString() {
        return "SoterPubKeyModel{counter=" + this.vlB + ", uid=" + this.uid + ", cpu_id='" + this.onE + '\'' + ", pub_key_in_x509='" + this.vlC + '\'' + ", rawJson='" + this.vlD + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public h(String str, String str2) {
        this.vlD = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.vlB = jSONObject.optLong("counter");
            this.uid = jSONObject.optInt("uid");
            this.onE = jSONObject.optString("cpu_id");
            this.vlC = jSONObject.optString("pub_key");
        } catch (JSONException e) {
            c.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
    }
}
