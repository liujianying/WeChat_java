package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends l implements k {
    private b diG;
    private e diJ;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract int aBO();

    public final void F(Map<String, String> map) {
        String uri;
        int If;
        int i = 0;
        if (!f.cfE()) {
            map.put("jsapi_reqkey", f.cfF());
        }
        if (this.diG == null) {
            a aVar = new a();
            aVar.dIG = new bsq();
            aVar.dIH = new bsr();
            uri = getUri();
            If = If();
            aVar.uri = uri;
            aVar.dIF = If;
            aVar.dII = 185;
            aVar.dIJ = 1000000185;
            this.diG = aVar.KT();
        }
        bsq bsq = (bsq) this.diG.dID.dIL;
        bsq.rPs = aBO();
        bsq.rPt = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        for (Object obj : toArray) {
            uri = (String) map.get(obj);
            if (!bi.oW(uri)) {
                if (i2 != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj);
                stringBuilder.append("=");
                stringBuilder.append(uri);
                i2 = 1;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        If = 0;
        while (true) {
            i2 = i;
            if (i2 >= toArray.length) {
                break;
            }
            int i3;
            Object obj2 = toArray[i2];
            uri = (String) map.get(obj2);
            if (bi.oW(uri)) {
                i3 = If;
            } else {
                if (If != 0) {
                    stringBuilder2.append("&");
                }
                stringBuilder2.append(obj2);
                stringBuilder2.append("=");
                stringBuilder2.append(p.encode(uri));
                i3 = 1;
            }
            i = i2 + 1;
            If = i3;
        }
        stringBuilder2.append(If != 0 ? "&" : "");
        stringBuilder2.append("WCPaySign");
        stringBuilder2.append("=");
        stringBuilder2.append(signWith3Des);
        bsq.rPu = new bhy().bq(stringBuilder2.toString().getBytes());
    }

    public final int getType() {
        return 385;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aBO() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        bsr bsr = (bsr) ((b) qVar).dIE.dIL;
        if (i2 != 0 || i3 != 0) {
            Map z = bl.z(str, "e");
            if (z != null) {
                x.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) z.get(".e.Content");
            }
        } else if (bsr.rPw == 0) {
            try {
                JSONObject jSONObject = new JSONObject(ab.b(bsr.rPv));
                int i4 = jSONObject.getInt("retcode");
                String str2 = bsr.scT;
                if (bi.oW(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = bsr.scS;
                if (i4 == 0 && i5 == 0) {
                    a(i4, str2, jSONObject);
                } else {
                    x.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : " + i5);
                    if (i5 == 0) {
                        i3 = -1000;
                    } else {
                        i3 = i5;
                    }
                    x.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : " + str2);
                    str = str2;
                    i2 = 1000;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = ad.getContext().getString(i.wallet_data_err);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = bsr.rPx;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            x.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aBO() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.diJ.a(i2, i3, str, this);
        x.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aBO() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int If() {
        return 385;
    }
}
