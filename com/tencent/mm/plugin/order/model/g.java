package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class g extends m {
    private b diG;
    private e diJ;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new azf();
        aVar.dIH = new azg();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.dIF = bk.CTRL_INDEX;
        aVar.dII = 187;
        aVar.dIJ = 1000000187;
        this.diG = aVar.KT();
        azf azf = (azf) this.diG.dID.dIL;
        azf.sbW = 1;
        if (!bi.oW(str)) {
            azf.lOE = str;
        }
        if (!bi.oW(str2)) {
            azf.lOX = str2;
        }
        azf.rmQ = i.bOL();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int bmw() {
        return ((azf) this.diG.dID.dIL).sbW;
    }

    public final String bmx() {
        return ((azf) this.diG.dID.dIL).lOE;
    }

    public final int getType() {
        return bk.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
