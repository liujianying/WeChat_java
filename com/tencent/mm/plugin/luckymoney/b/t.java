package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends r {
    public int ceS;
    public int ceT;
    public long cfh;
    public int hUg;
    public String kLZ;
    public RealnameGuideHelper kMP;
    public String kPJ;
    public a kPY;
    public String kQH;
    public String kQI;
    public int kQJ;
    public String kQK;
    public int kQL;
    public String kQM;
    public String kQN;
    public int kQO;
    public f kQP = null;

    public t(String str, String str2, int i, String str3, String str4) {
        this.kLZ = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        F(hashMap);
    }

    public final int aBM() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kQH = jSONObject.optString("spidName");
        this.ceS = jSONObject.optInt("hbStatus");
        this.ceT = jSONObject.optInt("receiveStatus");
        this.kPJ = jSONObject.optString("statusMess");
        this.kQI = jSONObject.optString("hintMess");
        this.cfh = jSONObject.optLong("amount");
        this.kQJ = jSONObject.optInt("recNum");
        this.hUg = jSONObject.optInt("totalNum");
        this.kPY = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.kPY.ddp = optJSONObject.optInt("enable");
            this.kPY.kPx = optJSONObject.optString("fissionContent");
            this.kPY.kPw = optJSONObject.optString("fissionUrl");
        }
        this.kQL = jSONObject.optInt("focusFlag");
        this.kQM = jSONObject.optString("focusWording");
        this.kQN = jSONObject.optString("focusAppidUserName");
        this.kQO = jSONObject.optInt("isFocus");
        this.kQK = jSONObject.optString("smallHbButtonMess");
        try {
            this.kQP = m.M(jSONObject);
            this.kQP.kPM = jSONObject.optString("spidLogo");
            this.kQP.kPL = jSONObject.optString("spidName");
            this.kQP.kLf = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            x.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.kMP = new RealnameGuideHelper();
                this.kMP.a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
    }
}
