package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class q extends m {
    b diG;
    private e diJ;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String aBL();

    public final void F(Map<String, String> map) {
        int i = 0;
        String GF = com.tencent.mm.model.q.GF();
        g.Ek();
        ab Yg = ((i) g.l(i.class)).FR().Yg(GF);
        if (Yg != null) {
            map.put("province", Yg.cla());
            map.put("city", Yg.getCityCode());
        }
        if (this.diG == null) {
            a aVar = new a();
            aVar.dIG = new amq();
            aVar.dIH = new amr();
            aVar.uri = aBL();
            aVar.dIF = getType();
            aVar.dII = 0;
            aVar.dIJ = 0;
            this.diG = aVar.KT();
            this.diG.dIU = true;
        }
        amq amq = (amq) this.diG.dID.dIL;
        amq.rPs = aBM();
        amq.rPt = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < toArray.length) {
                Object obj = toArray[i2];
                String str = (String) map.get(obj);
                if (!bi.oW(str)) {
                    if (i3 != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    boolean z = true;
                }
                i = i2 + 1;
            } else {
                x.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + amq.rPs + ", req = " + stringBuilder.toString());
                amq.rPu = new bhy().bq(stringBuilder.toString().getBytes());
                return;
            }
        }
    }

    public final void e(int i, int i2, String str, com.tencent.mm.network.q qVar) {
        x.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + aBM() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        amr amr = (amr) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            int i3 = amr.rPw;
            String b = com.tencent.mm.platformtools.ab.b(amr.rPv);
            if (i3 != 0 || bi.oW(b)) {
                str = amr.rPx;
                i2 = 2;
                i = BaseReportManager.MAX_READ_COUNT;
            } else {
                i3 = amr.bJL;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = amr.errorMsg;
                    if (bi.oW(b)) {
                        b = jSONObject.optString("retmsg");
                    }
                    if (jSONObject.has("showmess")) {
                        x.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        com.tencent.mm.plugin.wallet_core.model.a P = ae.P(jSONObject);
                        pl plVar = new pl();
                        plVar.can.cao = P;
                        com.tencent.mm.sdk.b.a.sFg.m(plVar);
                    } else if (i4 == 0 && i3 == 0) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = DownloadResult.CODE_UNDEFINED;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = BaseReportManager.MAX_READ_COUNT;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e, "", new Object[0]);
                    i2 = 2;
                    i = BaseReportManager.MAX_READ_COUNT;
                }
            }
        } else {
            Map z = bl.z(str, "e");
            if (z != null) {
                x.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
            str = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
        }
        if (i != 0) {
            x.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + aBM() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public int aBM() {
        return -1;
    }

    public final int baY() {
        return aBM();
    }
}
