package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i implements d, ITenpaySave {
    public String bQa = null;
    public String ced;
    public String cee;
    public String cef;
    public String ceg;
    public String ceh;
    public String oYA = "";
    public double oYD;
    private RetryPayInfo oYE;
    public boolean oYz = false;

    public c(double d, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        this.oYD = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", e.c(String.valueOf(d), "100", RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        F(hashMap);
    }

    public final int aBO() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.bQa = jSONObject.optString("req_key");
            this.oYz = "1".equals(jSONObject.optString("should_alert"));
            this.oYA = jSONObject.optString("alert_msg");
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", new Object[]{optJSONObject.toString()});
                this.ced = optJSONObject.optString("guide_flag");
                this.cee = optJSONObject.optString("guide_wording");
                this.cef = optJSONObject.optString("left_button_wording");
                this.ceg = optJSONObject.optString("right_button_wording");
                this.ceh = optJSONObject.optString("upload_credit_url");
            }
            this.oYE = new RetryPayInfo();
            this.oYE.ag(jSONObject);
        }
    }

    public final int If() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    public final RetryPayInfo bMO() {
        return this.oYE;
    }
}
