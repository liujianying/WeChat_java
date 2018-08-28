package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends i {
    public String bJg;
    public String desc;
    public String hUK = null;
    public double hUL;

    public s(double d, String str, String str2) {
        Map hashMap = new HashMap();
        try {
            hashMap.put("fee", Math.round(100.0d * d));
            hashMap.put("fee_type", str);
            hashMap.put("desc", URLEncoder.encode(str2, "UTF-8"));
        } catch (Throwable e) {
            x.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", e, "", new Object[0]);
        }
        this.hUL = d;
        this.bJg = str;
        this.desc = str2;
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1623;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersetf2ffee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.hUK = jSONObject.optString("pay_url");
        }
    }
}
