package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.og;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.p;

public final class a extends m {
    public b diG;
    private e diJ;
    public int piX;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        this.piX = 0;
        this.piX = i;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new og();
        aVar.dIH = new oh();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.dIF = 580;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        og ogVar = (og) this.diG.dID.dIL;
        ogVar.jQb = str;
        ogVar.rhq = str2;
        ogVar.rsw = str3;
        ogVar.rsx = str4;
        ogVar.rsz = str5;
        ogVar.rsy = str6;
        ogVar.rrC = str7;
        ogVar.rsA = i;
        ogVar.rmQ = i.bOL();
        if (p.cDb()) {
            ogVar.rsB = p.cDd();
        }
        ogVar.rcd = 1;
        ogVar.rsD = str8;
        ogVar.rsC = i2;
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[]{str, str7, Integer.valueOf(i)});
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
        this.piX = 0;
        this.piX = 16;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new og();
        aVar.dIH = new oh();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.dIF = 580;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        og ogVar = (og) this.diG.dID.dIL;
        ogVar.jQb = str;
        ogVar.rhq = str2;
        ogVar.rsw = str3;
        ogVar.rsx = str4;
        ogVar.rsz = str5;
        ogVar.rsy = str6;
        ogVar.rsA = 16;
        ogVar.hbL = str7;
        ogVar.jTx = str8;
        ogVar.rcd = 2;
        ogVar.rsD = str9;
        ogVar.rsC = i;
        ogVar.rmQ = i.bOL();
        if (p.cDb()) {
            ogVar.rsB = p.cDd();
        }
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[]{str, str7, str8});
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            oh ohVar = (oh) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + ohVar.iwS + " resp.ErrMsg is " + ohVar.iwT);
            og ogVar = (og) ((b) qVar).dID.dIL;
            if (ogVar.rrC != null) {
                if (Uri.parse(ogVar.rrC).getQueryParameter("appid") != ogVar.jQb) {
                    h.mEJ.h(14954, new Object[]{ohVar.qUU, "", Integer.valueOf(ogVar.rsA), ogVar.rsD, ogVar.jQb, Integer.valueOf(ogVar.rcd), Integer.valueOf(ogVar.rsC), ogVar.rrC, r2});
                } else {
                    h.mEJ.h(14954, new Object[]{ohVar.qUU, "", Integer.valueOf(ogVar.rsA), ogVar.rsD, ogVar.jQb, Integer.valueOf(ogVar.rcd), Integer.valueOf(ogVar.rsC), ogVar.rrC});
                }
            } else if (!(ogVar.hbL == null || ogVar.jTx == null)) {
                h.mEJ.h(14954, new Object[]{ohVar.qUU, "", Integer.valueOf(ogVar.rsA), ogVar.rsD, ogVar.jQb, Integer.valueOf(ogVar.rcd), Integer.valueOf(ogVar.rsC), ogVar.jTx, ogVar.hbL});
            }
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + ohVar.iwS + " resp.ErrMsg is " + ohVar.iwT);
            str = ohVar.iwT;
        }
        this.diJ.a(i, i2, str, this);
    }

    public final String blM() {
        return ((oh) this.diG.dIE.dIL).token;
    }

    public final String bOj() {
        return ((oh) this.diG.dIE.dIL).qUU;
    }
}
