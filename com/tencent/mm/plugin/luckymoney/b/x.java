package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.storage.aa;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class x extends ab {
    public int hUw;
    public String hUy;
    public String kKV;
    public String kKW;
    public String kLf;
    public ai kQa;
    public String kRc;
    public boolean kRd;
    public int kRe;
    public String kRf;
    public ai kRg;
    public ai kRh;
    public ai kRi;
    public int kRj = 0;
    public LinkedList<l> kRk;

    public x(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        g.Ek();
        hashMap.put("walletType", String.valueOf(g.Ei().DT().get(339975, null)));
        F(hashMap);
    }

    public x(String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("ver", str);
        g.Ek();
        hashMap.put("walletType", String.valueOf(g.Ei().DT().get(339975, null)));
        F(hashMap);
    }

    public final int getType() {
        return 1554;
    }

    public final String aBL() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.kRe = jSONObject.optInt("randomAmount");
            this.kRc = jSONObject.optString("randomWishing");
            this.hUy = jSONObject.optString("notice");
            this.kRf = jSONObject.optString("notice_url");
            this.kRd = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.hUw = jSONObject.optInt("currency");
            this.kKV = jSONObject.optString("currencyUint");
            this.kKW = jSONObject.optString("currencyWording");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.hUw + ";currencyUint=" + this.kKV + ";currencyWording=" + this.kKW);
            d dVar = new d();
            dVar.kPE = jSONObject.optString("groupHint");
            dVar.kPF = jSONObject.optString("personalHint");
            dVar.kKT = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            dVar.kKQ = jSONObject.optInt("totalNum", 100);
            dVar.kKR = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            dVar.kKU = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            dVar.kKS = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            dVar.kPG = jSONObject.optInt("payShowBGFlag");
            dVar.hUw = this.hUw;
            dVar.kKV = this.kKV;
            dVar.kKW = this.kKW;
            dVar.kPH = jSONObject.optString("foreignFaqUrl");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s", new Object[]{dVar.kPH});
            a.bat();
            e bau = a.bau();
            bau.kLu = dVar;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + bau.kLu.kKT + " maxTotalNum:" + bau.kLu.kKQ + " perGroupMaxValue:" + bau.kLu.kKU + " perMinValue:" + bau.kLu.kKS + " perPersonMaxValue:" + bau.kLu.kKR);
            try {
                String str2 = new String(bau.kLu.toByteArray(), "ISO-8859-1");
                g.Ek();
                g.Ei().DT().set(356355, str2);
                g.Ek();
                g.Ei().DT().lm(true);
            } catch (UnsupportedEncodingException e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.kRg = m.O(jSONObject.optJSONObject("operationHeader"));
            this.kQa = m.O(jSONObject.optJSONObject("operationTail"));
            this.kRh = m.O(jSONObject.optJSONObject("operationNext"));
            this.kRi = m.O(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.Ek();
            g.Ei().DT().a(aa.a.sPn, Integer.valueOf(optInt));
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + optInt);
            this.kRj = jSONObject.optInt("scenePicSwitch");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.kRj);
            this.kLf = jSONObject.optString("wishing");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[]{this.kLf});
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
            this.kRk = new LinkedList();
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                l lVar = new l();
                lVar.kQA = optJSONObject.optInt("yearAmount", 0);
                lVar.kQB = optJSONObject.optString("yearWish");
                this.kRk.add(lVar);
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
    }
}
