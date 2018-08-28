package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ag extends ab {
    long bJC;
    public int bxk;
    public String ceR;
    public int ceS;
    public int ceT;
    public String dwi;
    public String kLZ;
    public String kLf;
    public String kNj;
    public int kPI;
    public String kPJ;
    public String kPM;
    public int kPU;
    public int kQT = 1;
    public String kQU = null;
    public String kQV = null;
    public String kQW = null;
    public String kQX = null;
    public String kQY = null;
    public long kQZ = 0;
    public ai kQa;
    public String kQb;
    public String kQg;
    public long kRA;
    public int kRB;
    public String kRC;
    public int kRj = 0;
    public String kRy;
    public long kRz;
    public int msgType = 1;
    String talker;

    public ag(int i, String str, String str2, int i2, String str3) {
        this.bxk = i;
        this.kLZ = str;
        this.ceR = str2;
        Map hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put("channelId", String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
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
        if (!bi.oW(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        F(hashMap);
    }

    public final int getType() {
        return 1581;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.kRy = jSONObject.optString("sendNick");
        this.kPM = jSONObject.optString("sendHeadImg");
        this.ceS = jSONObject.optInt("hbStatus");
        this.ceT = jSONObject.optInt("receiveStatus");
        this.kPJ = jSONObject.optString("statusMess");
        this.kLf = jSONObject.optString("wishing");
        this.kPU = jSONObject.optInt("isSender");
        this.kRz = jSONObject.optLong("sceneAmount");
        this.kRA = jSONObject.optLong("sceneRecTimeStamp");
        this.kPI = jSONObject.optInt("hbType");
        this.kQb = jSONObject.optString("watermark");
        this.kNj = jSONObject.optString("externMess");
        this.kQg = jSONObject.optString("sendUserName");
        if (!bi.oW(this.kQg) && bi.oW(this.kRy)) {
            this.kRy = ((b) g.l(b.class)).gT(this.kQg);
        }
        this.kQa = m.O(jSONObject.optJSONObject("operationTail"));
        this.kRj = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.kQU = optJSONObject.optString("agreed_flag", "-1");
            this.kQV = optJSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE, "");
            this.kQW = optJSONObject.optString("service_protocol_wording", "");
            this.kQX = optJSONObject.optString("service_protocol_url", "");
            this.kQY = optJSONObject.optString("button_wording", "");
            this.kQZ = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.kQZ > 0) {
            g.Ek();
            g.Ei().DT().a(a.sTd, Long.valueOf(System.currentTimeMillis() + (this.kQZ * 1000)));
        }
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.kRj);
        this.kRB = jSONObject.optInt("preStrainFlag", 1);
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.kRB);
        g.Ek();
        g.Ei().DT().a(a.sSS, Integer.valueOf(this.kRB));
        this.kRC = jSONObject.optString("timingIdentifier");
        this.dwi = jSONObject.optString("effectResource");
    }

    public final boolean bba() {
        return this.kPU == 1;
    }
}
