package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r extends i {
    public String pjt;
    private int scene;
    public String token;

    public r(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i == 6) {
            hashMap.put("time_stamp", System.currentTimeMillis());
        }
        F(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        if (p.cDb()) {
            hashMap.put("uuid_for_bindcard", p.cDd());
            hashMap.put("bindcard_scene", p.cDc());
        }
        aC(hashMap);
        this.scene = i;
    }

    public final int aBO() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (this.scene == 6 || this.scene == 8 || this.scene == 18) {
            this.token = jSONObject.optString("usertoken");
            this.pjt = jSONObject.optString("token_type");
        }
    }

    public final int If() {
        return 476;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
