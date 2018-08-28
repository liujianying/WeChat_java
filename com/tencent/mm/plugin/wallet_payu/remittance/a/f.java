package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public int bNI;
    public int bWA;
    public double hUL;
    public String lNV;
    private String myq;
    public int myr;
    public int pFV;
    public int pFW;
    public int status;

    public f(String str, String str2, int i) {
        this(str, str2, i, 0);
    }

    public f(String str, String str2, int i, int i2) {
        this.myq = null;
        this.myq = str;
        this.bNI = 1;
        this.bWA = i2;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        F(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.myr = jSONObject.optInt("pay_time");
            this.hUL = jSONObject.optDouble("total_fee") / 100.0d;
            this.lNV = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("pay_status");
            this.pFV = jSONObject.optInt("refund_time");
            this.pFW = jSONObject.optInt("receive_time");
        }
    }

    public final int bOo() {
        return 25;
    }
}
