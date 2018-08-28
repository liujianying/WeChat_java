package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public k qwn;

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        F(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        aC(hashMap);
    }

    public final int aBO() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.qwn = new k();
                this.qwn.qwr = jSONObject.optInt("credit_state");
                this.qwn.qwm = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
                this.qwn.qws = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
                this.qwn.qwt = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
                this.qwn.qwu = jSONObject.optInt("bill_date");
                this.qwn.qwv = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
                this.qwn.qww = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
                k kVar = this.qwn;
                if (jSONObject.optInt("upgrade_amount") != 1) {
                    z = false;
                }
                kVar.qwx = z;
                this.qwn.qwy = jSONObject.optInt("bill_month");
                this.qwn.qwz = jSONObject.optString("repay_url");
                this.qwn.qwA = jSONObject.optString("repay_lasttime");
                this.qwn.qwE = jSONObject.optString("lasttime");
                JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.getString("jump_name");
                        if ("account_rights_url".equals(string)) {
                            this.qwn.qwC = jSONObject2.getString("jump_url");
                        } else if ("bill_url".equals(string)) {
                            this.qwn.qwD = jSONObject2.getString("jump_url");
                        } else if ("card_detail_url".equals(string)) {
                            this.qwn.qwB = jSONObject2.getString("jump_url");
                        } else if ("know_more_url".equals(string)) {
                            this.qwn.qwF = jSONObject2.getString("jump_url");
                        }
                    }
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
                if (jSONObject3 != null) {
                    this.qwn.qwG = new j();
                    this.qwn.qwG.qwq = jSONObject3.getString("app_telephone");
                    this.qwn.qwG.nickname = jSONObject3.getString("nickname");
                    this.qwn.qwG.username = jSONObject3.getString("username");
                    this.qwn.qwG.url = jSONObject3.getString("jump_url");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
