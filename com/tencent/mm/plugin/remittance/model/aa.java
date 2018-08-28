package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends a {
    public int hUw = 0;
    public int mxB;
    public String mxv = "";
    public String myC = "";
    public int myD;

    public aa(double d, String str, String str2, String str3, String str4, int i) {
        x.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        Map hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, "utf-8"));
            hashMap.put("rcvd_username", str2);
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, "utf-8"));
            hashMap.put("reason", URLEncoder.encode(bi.aG(str4, ""), "utf-8"));
            hashMap.put("currency", String.valueOf(i));
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        F(hashMap);
    }

    public final int aBM() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.mxv = jSONObject.optString("payurl");
        this.myC = jSONObject.optString("tradeurl");
        this.mxB = jSONObject.optInt("transfering_num");
        this.myD = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.mxv);
        stringBuffer.append(" tradeurl:" + this.myC);
        stringBuffer.append(" transfering_num:" + this.mxB);
        stringBuffer.append(" transfering_type:" + this.myD);
        x.i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1622;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
