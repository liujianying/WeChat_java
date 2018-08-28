package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    private Map<String, String> lKr = new HashMap();
    public String token = null;

    public f(Authen authen, boolean z, int i) {
        this.lKr.put("flag", authen.bWA);
        if (!bi.oW(authen.plr)) {
            this.lKr.put("first_name", authen.plr);
            this.lKr.put("last_name", authen.pls);
            this.lKr.put("country", authen.country);
            this.lKr.put("area", authen.csK);
            this.lKr.put("city", authen.csL);
            this.lKr.put("address", authen.dRH);
            this.lKr.put("phone_number", authen.knG);
            this.lKr.put("zip_code", authen.eXM);
            this.lKr.put("email", authen.csD);
        }
        this.lKr.put("business_source", String.valueOf(i));
        this.lKr.put("bank_type", authen.lMV);
        if (authen.pll > 0) {
            this.lKr.put("cre_type", authen.pll);
        }
        if (!bi.oW(authen.plj)) {
            this.lKr.put("true_name", authen.plj);
        }
        if (!bi.oW(authen.plk)) {
            this.lKr.put("identify_card", authen.plk);
        }
        this.lKr.put("mobile_no", authen.pjw);
        this.lKr.put("bank_card_id", authen.plm);
        if (!bi.oW(authen.pln)) {
            this.lKr.put("cvv2", authen.pln);
        }
        if (!bi.oW(authen.plo)) {
            this.lKr.put("valid_thru", authen.plo);
        }
        this.lKr.put("new_card_reset_pwd", z ? "1" : "0");
        F(this.lKr);
    }

    public final boolean bkT() {
        super.bkT();
        this.lKr.put("is_repeat_send", "1");
        F(this.lKr);
        return true;
    }

    public final int aBO() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
    }

    public final String blM() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int If() {
        return 469;
    }
}
