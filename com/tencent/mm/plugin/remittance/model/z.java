package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z extends a {
    public int hUw = 0;
    public String hUy;
    public String hUz;
    public String myA = "";
    public String myB = "";

    public z(int i) {
        x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        Map hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        F(hashMap);
    }

    public final int aBM() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.hUw = jSONObject.optInt("currency");
        this.myA = jSONObject.optString("currencyUint");
        this.myB = jSONObject.optString("currencyWording");
        this.hUy = jSONObject.optString("notice");
        this.hUz = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.hUw);
        stringBuffer.append(" currencyuint:" + this.myA);
        stringBuffer.append(" currencywording:" + this.myB);
        stringBuffer.append(" notice:" + this.hUy);
        stringBuffer.append(" notice_url:" + this.hUz);
        x.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1574;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
