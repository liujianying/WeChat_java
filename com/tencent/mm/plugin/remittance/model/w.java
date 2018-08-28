package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w extends i {
    public String desc;
    public double hUL;
    public String mxM;
    public String myb;
    public String myc;
    public String myd = "";
    public String mye = "";
    public String myf = "";
    public String myg = "";
    public int myh;
    public String myi = "";
    public String myj = "";
    public int myk;
    public String myl;
    public String mym;
    public int myn;
    public String myo;
    public BusiRemittanceResp myp;
    public int scene;
    public String username;

    public w(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        F(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        aC(hashMap);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
            if (i == 0) {
                x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[]{jSONObject.toString()});
                this.username = jSONObject.optString("user_name", "");
                this.myb = jSONObject.optString("true_name");
                this.hUL = jSONObject.optDouble("fee") / 100.0d;
                this.desc = jSONObject.optString("desc");
                this.scene = jSONObject.optInt("scene");
                this.myc = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
                this.myd = jSONObject.optString("f2f_pay_desc");
                this.mye = jSONObject.optString("rcvr_desc");
                this.myf = jSONObject.optString("payer_desc");
                this.myg = jSONObject.optString("rcvr_ticket");
                this.myh = jSONObject.optInt("busi_type", 0);
                this.myi = jSONObject.optString("mch_name");
                this.myj = jSONObject.optString("mch_photo");
                this.mym = jSONObject.optString("mch_type", "");
                this.myk = jSONObject.optInt("mch_time", 0);
                this.myl = jSONObject.optString("receiver_openid");
                this.myn = jSONObject.optInt("get_pay_wifi");
                this.mxM = jSONObject.optString("receiver_true_name");
                this.myo = jSONObject.optString("mch_info_string");
                this.myp = new BusiRemittanceResp(jSONObject);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e, "", new Object[0]);
        }
    }
}
