package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z extends ab {
    public String kRb;
    public h kRl;
    public List<String> kRm;
    public String kRn;
    public String kRo = null;

    public z(int i, int i2, int i3, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        F(hashMap);
    }

    public final int getType() {
        return 1514;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            int i2;
            h hVar = new h();
            hVar.kQk = jSONObject.optInt("recTotalNum");
            hVar.kQl = jSONObject.optLong("recTotalAmount");
            hVar.kQm = jSONObject.optInt("sendTotalNum");
            hVar.kQn = jSONObject.optLong("sendTotalAmount");
            hVar.kPV = jSONObject.optInt("isContinue");
            hVar.jzh = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.kQo = jSONObject2.optString("sendName");
                    iVar.kPM = jSONObject2.optString("sendHeadImg");
                    iVar.kQp = jSONObject2.optLong("receiveAmount");
                    iVar.kQq = jSONObject2.optString("receiveTime");
                    iVar.kPI = jSONObject2.optInt("hbType");
                    iVar.kQr = jSONObject2.optString("sendTitle");
                    iVar.kQs = jSONObject2.optString("sendTime");
                    iVar.kPR = jSONObject2.optLong("totalAmount");
                    iVar.kQt = jSONObject2.optLong("totalNum");
                    iVar.kPP = jSONObject2.optLong("recNum");
                    iVar.status = jSONObject2.optInt(DownloadInfo.STATUS);
                    iVar.kQu = jSONObject2.optInt("thxCount");
                    iVar.kPS = jSONObject2.optString("receiveId");
                    iVar.kLZ = jSONObject2.optString("sendId");
                    iVar.kQd = jSONObject2.optInt("hbKind");
                    linkedList.add(iVar);
                }
            }
            hVar.kQe = linkedList;
            this.kRl = hVar;
            this.kRm = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!bi.oW(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.kRm.add(add);
                    }
                }
            }
            this.kRn = jSONObject.optString("recordYear");
            this.kRo = jSONObject.optString("clickedUrl");
            this.kRb = jSONObject.optString("processContent");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
        }
    }

    public final boolean baZ() {
        if (this.kRl == null || this.kRl.kPV == 1) {
            return true;
        }
        return false;
    }
}
