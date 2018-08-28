package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad extends ab {
    long bJC;
    public String ceR;
    public String kLZ;
    public RealnameGuideHelper kMP;
    public f kQP = null;
    public String kRp;
    public String talker;

    public ad(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.kLZ = str;
        this.ceR = str2;
        this.talker = str5;
        Map hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put("channelId", String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!bi.oW(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(bi.oV(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        F(hashMap);
    }

    public final int getType() {
        return 1685;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            this.kQP = m.M(jSONObject);
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.kMP = new RealnameGuideHelper();
                    this.kMP.a(optString, optString2, optString3, optString4, optString5, 1003);
                }
            }
            this.kRp = jSONObject.optString("SystemMsgContext");
            if (i == 0 && !bi.oW(this.kRp) && !bi.oW(this.kQP.kQg)) {
                try {
                    this.kRp = this.kRp.replace("$" + this.kQP.kQg + "$", ((b) g.l(b.class)).gT(this.kQP.kQg));
                    o.dC(this.kRp, this.talker);
                } catch (Exception e) {
                    x.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", e.getMessage());
                }
            }
        } catch (JSONException e2) {
            x.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
        }
    }
}
