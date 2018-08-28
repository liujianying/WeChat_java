package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends com.tencent.mm.wallet_core.tenpay.model.i {
    public String bTi = "";
    public String lJT = "0";
    private String lJU = "0";
    private boolean lJV = false;

    public i(Bankcard bankcard, String str, String str2, int i, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("oper", str2);
        if (str2.equals("changeto")) {
            if (TextUtils.isEmpty(str3)) {
                hashMap.put("verify_code", "");
            } else {
                hashMap.put("verify_code", str3);
            }
            hashMap.put("chg_fee", String.valueOf(i));
            hashMap.put("bind_serialno", bankcard.field_bindSerial);
            hashMap.put("bank_type", bankcard.field_bankcardType);
            hashMap.put("card_tail", bankcard.field_bankcardTail);
        }
        this.bTi = bankcard.field_mobile;
        F(hashMap);
    }

    public final int aBO() {
        return 50;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lJT = jSONObject.optString("verify_flag");
            this.lJU = jSONObject.optString("limit_fee");
        }
    }
}
