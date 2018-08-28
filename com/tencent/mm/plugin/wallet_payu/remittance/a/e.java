package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public String desc;
    public double hUL;
    public String myb;
    public String myc;
    public int scene;
    public int timestamp;
    public String username;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        F(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.username = jSONObject.optString("user_name");
            this.myb = jSONObject.optString("true_name");
            this.hUL = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.myc = jSONObject.optString("transfer_qrcode_id");
            this.timestamp = jSONObject.optInt("time_stamp");
        }
    }

    public final int bOo() {
        return 24;
    }
}
