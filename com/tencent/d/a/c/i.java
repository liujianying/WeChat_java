package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public String signature = "";
    private long vlB = -1;
    private String vlE = null;
    public String vlF = null;
    private String vlG = "";
    private String vlH = "";
    private String vlI = "";
    private String vlJ = "";
    private String vlK = "";
    public int vlL = 20;
    public String vlM = "";

    public final String toString() {
        return "SoterSignatureResult{rawValue='" + this.vlE + '\'' + ", fid='" + this.vlF + '\'' + ", counter=" + this.vlB + ", TEEName='" + this.vlG + '\'' + ", TEEVersion='" + this.vlH + '\'' + ", FpName='" + this.vlI + '\'' + ", FpVersion='" + this.vlJ + '\'' + ", cpuId='" + this.vlK + '\'' + ", saltLen=" + this.vlL + ", jsonValue='" + this.vlM + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public static i acF(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i iVar = new i();
            iVar.vlM = str;
            iVar.vlE = jSONObject.optString("raw");
            iVar.vlF = jSONObject.optString("fid");
            iVar.vlB = jSONObject.optLong("counter");
            iVar.vlG = jSONObject.optString("tee_n");
            iVar.vlH = jSONObject.optString("tee_v");
            iVar.vlI = jSONObject.optString("fp_n");
            iVar.vlJ = jSONObject.optString("fp_v");
            iVar.vlK = jSONObject.optString("cpu_id");
            iVar.vlL = jSONObject.optInt("rsa_pss_saltlen", 20);
            return iVar;
        } catch (JSONException e) {
            c.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            return null;
        }
    }
}
