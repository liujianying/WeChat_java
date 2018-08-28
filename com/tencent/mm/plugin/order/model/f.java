package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public final class f extends m {
    private b diG;
    private e diJ;

    public f(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new ub();
        aVar.dIH = new uc();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        aVar.dIF = 583;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ub ubVar = (ub) this.diG.dID.dIL;
        ubVar.rxM = str;
        ubVar.jQb = str2;
        ubVar.mEc = i;
        ubVar.rmQ = i.bOL();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
