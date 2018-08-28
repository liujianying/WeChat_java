package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae extends ab {
    public a cao;
    public int hUg;
    public String kLZ;
    public String kRq;
    public String kRr;
    public String kRs;
    public String kRt;
    public String kRu = "";
    public String kRv = "";
    public String kRw = "";
    public String kRx;

    public ae(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.hUg = i;
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bi.oV(str)));
        hashMap.put("sendUserName", str5);
        if (!bi.oW(str3)) {
            hashMap.put("username", str3);
        }
        if (!bi.oW(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(bi.oV(str6)));
            if (!bi.oW(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", "0");
        }
        F(hashMap);
    }

    public final int getType() {
        return 1575;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kLZ = jSONObject.optString("sendId");
        this.kRq = jSONObject.optString("reqkey");
        this.kRr = jSONObject.optString("sendMsgXml");
        this.kRs = jSONObject.optString("guide_flag", "0");
        this.kRt = jSONObject.optString("guide_wording");
        this.kRu = jSONObject.optString("left_button_wording", "");
        this.kRv = jSONObject.optString("right_button_wording", "");
        this.kRw = jSONObject.optString("upload_credit_url", "");
        this.kRx = jSONObject.optString("id_sign", "");
        if (jSONObject.has("showmess")) {
            x.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
            this.cao = P(jSONObject);
        }
    }

    public static a P(JSONObject jSONObject) {
        a aVar = new a();
        aVar.bSc = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.kRu = optJSONObject.optString("left_button_wording");
        aVar.kRv = optJSONObject.optString("right_button_wording");
        aVar.hUt = optJSONObject.optString("right_button_url");
        return aVar;
    }
}
