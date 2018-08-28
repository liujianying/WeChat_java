package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i implements d {
    public int bIH = 0;
    public String bQa = null;
    public String ced;
    public String cee;
    public String cef;
    public String ceg;
    public String ceh;
    public double mxE = 0.0d;
    public double mxP = 0.0d;
    public String oYA = "";
    public com.tencent.mm.plugin.wallet_core.model.b oYB;
    public com.tencent.mm.plugin.wallet_core.model.b oYC;
    public double oYD;
    public boolean oYz = false;

    public b(double d, String str, String str2, int i) {
        Map hashMap = new HashMap();
        this.oYD = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", e.c(String.valueOf(d), "100", RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        F(hashMap);
    }

    public final int aBO() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.bQa = jSONObject.optString("req_key");
            this.oYz = "1".equals(jSONObject.optString("should_alert"));
            this.oYA = jSONObject.optString("alert_msg");
            this.mxE = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            this.mxP = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
            JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
                this.oYB = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
            }
            optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
                this.oYC = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
            }
            this.bIH = jSONObject.optInt("operation", 0);
            x.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.mxE + " total_fee:" + this.mxP + " operation:" + this.bIH);
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject.toString());
                this.ced = optJSONObject.optString("guide_flag");
                this.cee = optJSONObject.optString("guide_wording");
                this.cef = optJSONObject.optString("left_button_wording");
                this.ceg = optJSONObject.optString("right_button_wording");
                this.ceh = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int If() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }
}
