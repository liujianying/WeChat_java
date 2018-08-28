package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public static final int[] mot = new int[]{-1, -1};
    public static final int[] mou = new int[]{-2, -2};
    public int bJt;
    public String mov;
    public String mow;
    public int[] mox;
    public String name;

    public a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public a(String str, String str2, String str3, int i) {
        this.mox = mot;
        this.mov = str;
        this.name = str2;
        this.mow = str3;
        this.bJt = i;
    }

    public final JSONObject bpY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", bi.aG(this.mov, ""));
            jSONObject.put("name", bi.aG(this.name, ""));
            jSONObject.put("location", bi.aG(this.mow, ""));
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            return null;
        }
    }

    public static a Z(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString("location");
        if (bi.oW(optString2)) {
            return null;
        }
        return new a(optString2, optString, optString3, 2);
    }
}
