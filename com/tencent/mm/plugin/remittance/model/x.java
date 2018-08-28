package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x extends i {
    public double hUL;
    public boolean klL;
    public String lNV;
    public int lOD;
    public String lOt;
    private String myq = null;
    public int myr;
    private String mys;
    public String myt;
    public int myu;
    public String myv;
    public String myw;
    public int myx;
    public String myy;
    public String myz;
    public int status;

    public x(int i, String str, String str2, int i2) {
        this.myq = str;
        this.lOD = i;
        Map hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        F(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        com.tencent.mm.sdk.platformtools.x.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.myr = jSONObject.optInt("pay_time");
            this.hUL = jSONObject.optDouble("fee") / 100.0d;
            this.lNV = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("trans_status");
            this.mys = jSONObject.optString("trans_status_name");
            this.myu = jSONObject.optInt("modify_time");
            this.klL = jSONObject.optBoolean("is_payer");
            this.lOt = jSONObject.optString("refund_bank_type");
            this.myv = jSONObject.optString("status_desc");
            this.myw = jSONObject.optString("status_supplementary");
            this.myx = jSONObject.optInt("delay_confirm_flag");
            this.myy = jSONObject.optString("banner_content");
            this.myz = jSONObject.optString("banner_url");
        }
    }
}
