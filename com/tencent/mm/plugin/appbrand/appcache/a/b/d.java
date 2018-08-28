package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.chp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public class d extends a<Boolean, chp> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        chp chp = (chp) obj;
        if (bi.oW(str) && bi.oW(str2)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdGetContact", "invalid username & appId");
            return Boolean.FALSE;
        }
        b cBF = g.cBF();
        cBF.cBE();
        int i = chp.sBu.sBs;
        int i2 = a.fiY;
        a.n((long) i, 24);
        new l(str, str2).KM().j(new 1(this, str, cBF, i));
        return Boolean.TRUE;
    }

    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((chp) obj).sBu;
    }

    final String acp() {
        return "CmdGetContact";
    }
}
