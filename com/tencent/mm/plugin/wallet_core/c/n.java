package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends i {
    public String hKX;
    public String pjp;
    public String pjq;
    public Promotions pjs;

    public n(Promotions promotions, String str, String str2, long j) {
        this.pjs = promotions;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", promotions.pji);
        hashMap.put("award_id", promotions.ppU);
        hashMap.put("send_record_id", promotions.poD);
        hashMap.put("user_record_id", promotions.poE);
        hashMap.put("req_key", str);
        hashMap.put("transaction_id", str2);
        hashMap.put("activity_mch_id", String.valueOf(j));
        F(hashMap);
    }

    public final int aBO() {
        return 1589;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[]{Integer.valueOf(i), str, jSONObject});
        if (jSONObject != null && i == 0) {
            this.pjp = jSONObject.optString("result_code");
            this.hKX = jSONObject.optString("result_msg");
            this.pjq = jSONObject.optString("alert_wording");
        }
    }

    public final int If() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
