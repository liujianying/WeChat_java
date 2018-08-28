package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bJg;
    public String bOd;
    public String hTI;
    public double mBj;
    public String pDO;
    public String pDP;
    public String pDQ;
    public String pDR;
    public int pDS;
    public boolean pDT;
    public String pDU;
    public String pDV;
    public boolean pDW;
    public String pDX;
    public String pin;

    public b(String str, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.pin = str;
        this.pDO = str2;
        this.bOd = str3;
        this.mBj = d;
        this.bJg = str4;
        this.pDP = str5;
        this.pDQ = str6;
        this.pDR = str7;
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        F(hashMap);
    }

    public final int bOo() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.hTI = jSONObject.optString("trans_id");
        this.pDS = jSONObject.optInt("response_result");
        this.pDT = jSONObject.optBoolean("redirect");
        this.pDU = jSONObject.optString("gateway_reference");
        this.pDV = jSONObject.optString("gateway_code");
        this.pDW = jSONObject.optBoolean("is_force_adjust");
        this.pDX = jSONObject.optString("force_adjust_code");
    }
}
