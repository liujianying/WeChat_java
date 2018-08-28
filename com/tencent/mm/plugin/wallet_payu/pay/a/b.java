package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String bOd;
    public String hTI;
    public String pDO;
    public String pDU;
    public String pDV;
    public String pDX;
    public double pFm;
    public String pFn;
    public double pFo;
    public String pFp;
    public boolean pFq;
    public boolean pFr;
    public String pFs;
    public String pFt;
    public String pFu;
    public String pct;
    public String pin;
    public String psA;
    public int timestamp;

    public b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        this.bOd = str;
        this.pFm = d;
        this.pFn = str2;
        this.psA = str3;
        this.pct = str4;
        this.pDO = str5;
        this.pin = str6;
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", str3);
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", str5);
        }
        hashMap.put("pin", str6);
        F(hashMap);
    }

    public final int bOo() {
        return 9;
    }

    public final boolean isSuccess() {
        return this.pFs.equals("1");
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hTI = jSONObject.optString("trans_id");
            this.pFo = jSONObject.optDouble("total_fee") / 100.0d;
            this.pFp = jSONObject.optString("fee_type");
            this.pFq = jSONObject.optBoolean("redirect");
            this.pDU = jSONObject.optString("gateway_reference");
            this.pDV = jSONObject.optString("gateway_code");
            this.pFs = jSONObject.optString("pay_status");
            this.timestamp = jSONObject.optInt("timestamp");
            this.pFt = jSONObject.optString("pay_status_name");
            this.pFu = jSONObject.optString("bank_type");
            this.pFr = jSONObject.optBoolean("is_force_adjust");
            this.pDX = jSONObject.optString("force_adjust_code");
        }
    }
}
