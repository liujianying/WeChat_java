package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String name;
    public String qwk;
    public boolean qwl = true;
    public String token;

    public b(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        F(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        aC(hashMap);
    }

    public final int aBO() {
        return 63;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.token = jSONObject.optString("session_key");
            if ("1".equals(jSONObject.optString("all_info"))) {
                this.qwl = false;
                return;
            }
            this.qwl = true;
            this.name = jSONObject.optString("name");
            this.qwk = jSONObject.optString("cre_id");
        }
    }
}
