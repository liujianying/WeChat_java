package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;

public final class g extends h {
    private b diG;
    private e diJ;
    public bde pCe;

    public g() {
        a aVar = new a();
        aVar.dIG = new bdd();
        aVar.dIH = new bde();
        aVar.dIF = 2931;
        aVar.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bdd) this.diG.dID.dIL).sfn = 1;
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pCe = (bde) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pCe.hwV), this.pCe.hwW});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bde bde = (bde) ((b) qVar).dIE.dIL;
        this.uXe = bde.hwV;
        this.uXf = bde.hwW;
    }

    public final int getType() {
        return 2931;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
