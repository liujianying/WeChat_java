package com.tencent.mm.plugin.wallet_core.c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class b extends m {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public int piX;
    public ot piY;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this(str, str2, str3, str4, str5, str6, str7, str8, i, (byte) 0);
    }

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, byte b) {
        this.piX = 0;
        this.piX = 5;
        a aVar = new a();
        aVar.dIG = new os();
        aVar.dIH = new ot();
        aVar.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        aVar.dIF = 2728;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        os osVar = (os) this.diG.dID.dIL;
        osVar.jQb = str;
        osVar.rhq = str2;
        osVar.rsw = str3;
        osVar.rsx = str4;
        osVar.rsz = str5;
        osVar.rsy = str6;
        osVar.rrC = str7;
        osVar.rsA = 5;
        osVar.rmQ = i.bOL();
        osVar.rcd = 1;
        osVar.hbL = null;
        osVar.jTx = null;
        osVar.rsD = str8;
        osVar.rsC = i;
        boolean aNa = ((k) g.l(k.class)).aNa();
        SharedPreferences chZ = ad.chZ();
        String str9 = null;
        String str10 = null;
        if (chZ != null) {
            str9 = chZ.getString("cpu_id", null);
            str10 = chZ.getString("uid", null);
        }
        osVar.rsW = 0;
        osVar.onE = str9;
        osVar.onF = str10;
        osVar.rsX = aNa ? 1 : 0;
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[]{str9, str10});
        x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[]{str, str7, Integer.valueOf(5), Boolean.valueOf(aNa)});
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            this.piY = (ot) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            os osVar = (os) ((com.tencent.mm.ab.b) qVar).dID.dIL;
            if (osVar.rrC != null) {
                if (Uri.parse(osVar.rrC).getQueryParameter("appid") != osVar.jQb) {
                    h.mEJ.h(14954, new Object[]{this.piY.qUU, "", Integer.valueOf(osVar.rsA), osVar.rsD, osVar.jQb, Integer.valueOf(osVar.rcd), Integer.valueOf(osVar.rsC), osVar.rrC, r1});
                } else {
                    h.mEJ.h(14954, new Object[]{this.piY.qUU, "", Integer.valueOf(osVar.rsA), osVar.rsD, osVar.jQb, Integer.valueOf(osVar.rcd), Integer.valueOf(osVar.rsC), osVar.rrC});
                }
            } else if (!(osVar.hbL == null || osVar.jTx == null)) {
                h.mEJ.h(14954, new Object[]{this.piY.qUU, "", Integer.valueOf(osVar.rsA), osVar.rsD, osVar.jQb, Integer.valueOf(osVar.rcd), Integer.valueOf(osVar.rsC), osVar.jTx, osVar.hbL});
            }
            x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.piY.iwS + " resp.ErrMsg is " + this.piY.iwT);
            str = this.piY.iwT;
        }
        this.diJ.a(i, i2, str, this);
    }
}
