package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.c.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class j extends l implements d {
    private static int uYd = 0;
    public RealnameGuideHelper lJN;
    private String lJO;
    private String lJP;
    private String lJQ;
    private String lJR;
    private String lJS;
    protected int lNG;
    public String phl;
    public int ppo = 0;
    protected Map<String, String> uYb = new HashMap();
    public int uYc = 0;
    private boolean uYe = false;
    public int uYf = 0;
    public int uYg = 0;
    public String uYh = null;
    public JSONObject uYi = null;
    private boolean uYj = false;

    public final void a(String str, String str2, int i, int i2, String str3, String str4) {
        uYd++;
        this.uYb.put("req_key", str);
        this.uYb.put("transaction_id", str2);
        this.uYb.put("pay_scene", String.valueOf(i));
        this.uYb.put("bank_type", str3);
        this.uYb.put("channel", String.valueOf(i2));
        this.uYb.put("bind_serial", str4);
    }

    public final Map<String, String> cDA() {
        return this.uYb;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        boolean z;
        JSONObject optJSONObject;
        if (!this.uYe) {
            this.uYg = i;
            this.uYh = str;
            this.uYi = jSONObject;
            this.uYe = true;
            if (jSONObject != null) {
                this.uYc = jSONObject.optInt("query_order_flag", 0);
            }
        }
        if (jSONObject == null || !jSONObject.has("real_name_info")) {
            z = false;
        } else {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            this.lJO = optJSONObject.optString("guide_flag");
            this.lJP = optJSONObject.optString("guide_wording");
            this.lJQ = optJSONObject.optString("left_button_wording");
            this.lJR = optJSONObject.optString("right_button_wording");
            this.lJS = optJSONObject.optString("upload_credit_url");
            z = true;
        }
        SetPwdInfo setPwdInfo = null;
        if (jSONObject != null && jSONObject.has("set_pwd_info")) {
            optJSONObject = jSONObject.optJSONObject("set_pwd_info");
            setPwdInfo = new SetPwdInfo();
            setPwdInfo.kRt = optJSONObject.optString("guide_wording");
            setPwdInfo.kRu = optJSONObject.optString("left_button_wording");
            setPwdInfo.kRv = optJSONObject.optString("right_button_wording");
            setPwdInfo.plg = optJSONObject.optInt("send_pwd_msg");
            z = true;
        }
        if (z && ("1".equals(this.lJO) || "2".equals(this.lJO) || setPwdInfo != null)) {
            this.lJN = new RealnameGuideHelper();
            this.lJN.a(this.lJO, setPwdInfo, this.lJP, this.lJQ, this.lJR, this.lJS, this.lNG);
        }
        this.phl = jSONObject.optString("forget_pwd_url", "");
        x.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", this.phl);
        this.uYj = true;
        super.a(i, str, jSONObject);
    }

    public final boolean cDB() {
        return this.uYc == 1;
    }

    public final void a(c cVar, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", Integer.valueOf(cVar.errCode), cVar.Yy);
        if (!this.uYj && !this.uYe) {
            this.uYf = cVar.errType;
            this.uYg = cVar.errCode;
            this.uYh = cVar.Yy;
            if (jSONObject != null) {
                this.uYc = jSONObject.optInt("query_order_flag", 0);
                this.uYi = jSONObject;
            }
            this.uYe = true;
        }
    }

    public boolean bNv() {
        return false;
    }

    public final boolean cDq() {
        return false;
    }
}
