package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private final String appId;
    private final String bKg;
    private final String fxc;
    private final boolean fxd;

    private c(String str, String str2, String str3) {
        this.appId = str;
        this.bKg = str2;
        this.fxc = str3;
        this.fxd = false;
    }

    public c(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    private void g(int i, String str, String str2) {
        ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(this.appId, i, str, str2, 0, 0);
    }

    public final int afr() {
        String str = this.appId;
        String str2 = this.bKg;
        String str3 = this.fxc;
        a aVar = new a();
        nq nqVar = new nq();
        nqVar.bPS = str;
        nqVar.rrG = str2;
        nqVar.rrH = str3;
        aVar.dIG = nqVar;
        aVar.dIH = new nr();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.dIF = 1124;
        com.tencent.mm.ab.a.a b = w.b(aVar.KT());
        if (b.errType == 0 && b.errCode == 0) {
            try {
                nr nrVar = (nr) b.dIv;
                if (nrVar.rrI == null) {
                    x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[]{this.appId});
                    return a.fxi - 1;
                }
                x.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[]{this.appId, Integer.valueOf(nrVar.rrI.iwS), Boolean.valueOf(nrVar.rrJ), nrVar.rrK, nrVar.rrL});
                if (nrVar.rrI.iwS != 0) {
                    return nrVar.rrI.iwS;
                }
                if (!(!nrVar.rrJ || bi.oW(nrVar.rrL) || bi.oW(nrVar.rrK))) {
                    g(2, nrVar.rrK, nrVar.rrL);
                }
                if (!(!nrVar.rrM || bi.oW(nrVar.rrO) || bi.oW(nrVar.rrN))) {
                    g(10001, nrVar.rrN, nrVar.rrO);
                }
                return a.fxe - 1;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[]{this.appId});
                return a.fxi - 1;
            }
        }
        x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[]{this.appId, Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.Yy});
        return a.fxh - 1;
    }
}
