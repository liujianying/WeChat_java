package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.wallet_core.c.m;

public final class b extends m {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public String jumpUrl;
    public int pjQ = 0;

    public b() {
        boolean booleanValue;
        a aVar = new a();
        azp azp = new azp();
        g.Ek();
        Object obj = g.Ei().DT().get(aa.a.sSo, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        azp.scg = booleanValue ? 1 : 0;
        aVar.dIG = azp;
        aVar.dIH = new azq();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.dIF = 1564;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        azq azq = (azq) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[]{Integer.valueOf(azq.iwS), azq.iwT});
            str = azq.iwT;
            i2 = azq.iwS;
            this.jumpUrl = azq.jOU;
            this.pjQ = azq.sch;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (bi.oW(str)) {
            str = ad.getContext().getString(i.wallet_data_err);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
