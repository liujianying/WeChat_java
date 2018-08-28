package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends r {
    public String ceR;
    public int ceS;
    public int ceT;
    public String kLZ;
    public int kPI;
    public String kPJ;
    public String kQH;
    public String kQI;
    public int kQL;
    public String kQM;
    public String kQN;
    public int kQO;
    public int kQQ;
    public String kQR;
    public String kQS;
    public int kQT = 1;
    public String kQU = null;
    public String kQV = null;
    public String kQW = null;
    public String kQX = null;
    public String kQY = null;
    public long kQZ = 0;
    public ai kQa;
    public String kQb;

    public u(String str, String str2, int i, String str3) {
        this.ceR = str2;
        this.kLZ = str;
        this.kQQ = i;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put("channelId", "2");
        hashMap.put("package", str3);
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(a.sTd, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                g.Ek();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) g.Ei().DT().get(a.sTe, Integer.valueOf(1))).toString());
            }
        }
        F(hashMap);
    }

    public final int aBM() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kQR = jSONObject.optString("spidLogo");
        this.kQS = jSONObject.optString("spidWishing");
        this.kQH = jSONObject.optString("spidName");
        this.kQR = jSONObject.optString("spidLogo");
        this.ceS = jSONObject.optInt("hbStatus");
        this.ceT = jSONObject.optInt("receiveStatus");
        this.kPJ = jSONObject.optString("statusMess");
        this.kQI = jSONObject.optString("hintMess");
        this.kQb = jSONObject.optString("watermark");
        this.kLZ = jSONObject.optString("sendId");
        this.kQL = jSONObject.optInt("focusFlag");
        this.kQM = jSONObject.optString("focusWording");
        this.kQN = jSONObject.optString("focusAppidUserName");
        this.kQO = jSONObject.optInt("isFocus");
        this.kPI = jSONObject.optInt("hbType");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.kQU = optJSONObject.optString("agreed_flag", "-1");
            this.kQV = optJSONObject.optString("title", "");
            this.kQW = optJSONObject.optString("service_protocol_wording", "");
            this.kQX = optJSONObject.optString("service_protocol_url", "");
            this.kQY = optJSONObject.optString("button_wording", "");
            this.kQZ = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.kQZ > 0) {
            g.Ek();
            g.Ei().DT().a(a.sTd, Long.valueOf(System.currentTimeMillis() + (this.kQZ * 1000)));
        }
        this.kQa = m.O(jSONObject.optJSONObject("operationTail"));
    }
}
