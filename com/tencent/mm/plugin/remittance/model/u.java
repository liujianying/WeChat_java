package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends i {
    public String kRs = "";
    public String mxA = null;

    public u(String str, String str2, int i, String str3, String str4, int i2) {
        this.mxA = str3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put("transaction_id", str);
        hashMap.put("op", str3);
        hashMap.put("username", str4);
        hashMap.put("invalid_time", String.valueOf(i2));
        hashMap.put("total_fee", String.valueOf(i));
        x.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i);
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1691;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                this.kRs = optJSONObject.optString("guide_flag", "0");
            }
        }
    }
}
