package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public String pkN;
    public String pkO;
    public String pkP;
    public String pkQ;
    public String pkR;

    public f(String str) {
        Map hashMap = new HashMap();
        hashMap.put("channel", "1");
        F(hashMap);
        this.pkR = str;
    }

    public final int aBO() {
        return 1630;
    }

    public final int If() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0 && jSONObject != null) {
            this.pkN = jSONObject.optString("guide_flag");
            this.pkO = jSONObject.optString("guide_wording");
            this.pkP = jSONObject.optString("left_button_wording");
            this.pkQ = jSONObject.optString("right_button_wording");
        }
    }
}
