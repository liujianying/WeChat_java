package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public String bTi;
    public boolean cdW = true;
    private Map<String, String> lKr = new HashMap();
    public boolean qwj = false;
    public String token;

    public a(String str, String str2, String str3, String str4) {
        this.lKr.put("session_key", str3);
        this.lKr.put("bank_type", str4);
        this.lKr.put("name", str);
        this.lKr.put("cre_id", str2);
        F(this.lKr);
    }

    public final boolean bkT() {
        super.bkT();
        this.lKr.put("retry", "1");
        F(this.lKr);
        return true;
    }

    public final int aBO() {
        return 64;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.optString("session_key");
                this.cdW = "1".equals(jSONObject.getString("need_bind"));
                this.qwj = "1".equals(jSONObject.getString("bank_user"));
                this.bTi = jSONObject.optString("mobile_no");
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
