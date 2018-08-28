package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String bJg;
    public String bOd;
    public String bZR;
    public double mBj;
    public int pDS;
    public int pFR;
    public double pFS;
    public String pFT;
    public String pct;
    public String pin;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        this.bOd = str;
        this.pin = str2;
        this.mBj = d;
        this.bJg = str3;
        this.pFR = i == 2 ? 0 : i;
        this.bZR = str4;
        this.pct = str5;
        Map hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        F(hashMap);
    }

    public final int bOo() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pDS = jSONObject.optInt("response_result");
        this.pFS = bi.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.pFT = jSONObject.optString("fee_type");
    }
}
