package com.tencent.mm.wallet_core.b.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends m {
    private b diG;
    private e diJ;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract String aBL();

    public abstract int aBM();

    public final void F(Map<String, String> map) {
        int i = 0;
        if (this.diG == null) {
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
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
                x.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + amq.rPs + ", req = " + stringBuilder.toString());
                amq.rPu = new bhy().bq(stringBuilder.toString().getBytes());
                return;
            }
        }
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + aBM() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str + " " + getType());
        amr amr = (amr) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            int i3 = amr.rPw;
            String b = ab.b(amr.rPv);
            if (i3 != 0 || bi.oW(b)) {
                str = amr.rPx;
                i2 = 2;
                i = TbsLog.TBSLOG_CODE_SDK_BASE;
            } else {
                i3 = amr.bJL;
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    int i4 = jSONObject.getInt("retcode");
                    b = jSONObject.optString("retmsg");
                    if (bi.oW(b)) {
                        b = amr.errorMsg;
                    }
                    if ((i4 == 0 && i3 == 0) || aBN()) {
                        a(i4, b, jSONObject);
                    } else {
                        int i5;
                        if (i3 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i3;
                        }
                        str = b;
                        i2 = i5;
                        i = TbsLog.TBSLOG_CODE_SDK_BASE;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e, "", new Object[0]);
                    i2 = 2;
                    i = TbsLog.TBSLOG_CODE_SDK_BASE;
                }
            }
        } else {
            Map z = bl.z(str, "e");
            if (z != null) {
                x.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
            str = ad.getContext().getString(i.wallet_data_err);
        }
        if (i != 0) {
            x.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + aBM() + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public boolean aBN() {
        return false;
    }
}
