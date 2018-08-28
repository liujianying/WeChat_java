package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public static f M(JSONObject jSONObject) {
        f fVar = new f();
        if (jSONObject != null) {
            fVar.kPI = jSONObject.optInt("hbType");
            fVar.ceS = jSONObject.optInt("hbStatus");
            fVar.kPJ = jSONObject.optString("statusMess");
            fVar.kPK = jSONObject.optString("gameMess");
            fVar.kLf = jSONObject.optString("wishing");
            fVar.kPL = jSONObject.optString("sendNick");
            fVar.kPM = jSONObject.optString("sendHeadImg");
            fVar.kLZ = jSONObject.optString("sendId");
            fVar.kPN = jSONObject.optString("adMessage");
            fVar.kPO = jSONObject.optString("adUrl");
            fVar.cfh = jSONObject.optLong("amount");
            fVar.kPP = jSONObject.optLong("recNum");
            fVar.kPQ = jSONObject.optLong("recAmount");
            fVar.hUg = jSONObject.optInt("totalNum");
            fVar.kPR = jSONObject.optLong("totalAmount");
            fVar.kPS = jSONObject.optString("receiveId");
            fVar.kPT = jSONObject.optInt("hasWriteAnswer");
            fVar.kPU = jSONObject.optInt("isSender");
            fVar.kPV = jSONObject.optInt("isContinue");
            fVar.kPW = jSONObject.optString("headTitle");
            fVar.ceT = jSONObject.optInt("receiveStatus");
            fVar.kPX = jSONObject.optInt("canShare");
            fVar.kNg = jSONObject.optInt("jumpChange");
            fVar.kNi = jSONObject.optString("changeWording");
            fVar.kNh = jSONObject.optString("changeUrl");
            fVar.kQd = jSONObject.optInt("hbKind");
            fVar.kNj = jSONObject.optString("externMess");
            fVar.kQg = jSONObject.optString("sendUserName");
            if (bi.oW(fVar.kPL) && !bi.oW(fVar.kQg)) {
                fVar.kPL = ((b) g.l(b.class)).gT(fVar.kQg);
            }
            fVar.kPY = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                fVar.kPY.ddp = optJSONObject.optInt("enable");
                fVar.kPY.kPx = optJSONObject.optString("fissionContent");
                fVar.kPY.kPw = optJSONObject.optString("fissionUrl");
            }
            fVar.kPZ = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    fVar.kPZ.add(O(optJSONArray.getJSONObject(i)));
                }
            }
            fVar.kQb = jSONObject.optString("watermark");
            fVar.kQc = jSONObject.optString("context");
            fVar.kQf = jSONObject.optString("contextMd5");
            fVar.resourceId = jSONObject.optInt("resourceId");
            fVar.kQa = O(jSONObject.optJSONObject("operationTail"));
            fVar.kQe = N(jSONObject);
            fVar.kQh = jSONObject.optInt("jumpChangeType");
            fVar.kQi = jSONObject.optString("changeIconUrl");
        }
        return fVar;
    }

    private static LinkedList<n> N(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList<n> linkedList = new LinkedList();
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                n nVar = new n();
                if (jSONObject2 != null) {
                    nVar.kQC = jSONObject2.optString("receiveName");
                    nVar.kQD = jSONObject2.optString("receiveHeadImg");
                    nVar.kQp = jSONObject2.optLong("receiveAmount");
                    nVar.kQq = jSONObject2.optString("receiveTime");
                    nVar.kQE = jSONObject2.optString("answer");
                    nVar.kPS = jSONObject2.optString("receiveId");
                    nVar.kQF = jSONObject2.optString("gameTips");
                    nVar.userName = jSONObject2.optString("userName");
                    if (bi.oW(nVar.kQC) && !bi.oW(nVar.userName)) {
                        nVar.kQC = ((b) g.l(b.class)).gT(nVar.userName);
                    }
                }
                linkedList.add(nVar);
                i = i2 + 1;
            }
        }
        return linkedList;
    }

    public static ai O(JSONObject jSONObject) {
        ai aiVar = new ai();
        if (jSONObject != null) {
            aiVar.ddp = jSONObject.optInt("enable", 0);
            aiVar.content = jSONObject.optString("content");
            aiVar.iconUrl = jSONObject.optString("iconUrl");
            aiVar.type = jSONObject.optString("type");
            aiVar.name = jSONObject.optString("name");
            aiVar.kRD = jSONObject.optInt("ossKey");
            aiVar.kRE = jSONObject.optInt("focus");
        }
        return aiVar;
    }
}
