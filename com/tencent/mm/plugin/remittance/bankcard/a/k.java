package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aym;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class k extends b {
    private b diG;
    private e diJ;
    public ayn muc;

    public k() {
        a aVar = new a();
        aVar.dIG = new aym();
        aVar.dIH = new ayn();
        aVar.dIF = 1280;
        aVar.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1280;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.muc = (ayn) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.muc.hUm), this.muc.hUn});
        if (!(this.hUU || this.hUV)) {
            x.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", new Object[]{Integer.valueOf(this.muc.sbr), Integer.valueOf(this.muc.sbs)});
            if (this.muc.sbr >= 0) {
                g.Ei().DT().a(aa.a.sZi, Integer.valueOf(this.muc.sbr));
            }
            if (this.muc.sbs > 0) {
                g.Ei().DT().a(aa.a.sZj, Integer.valueOf(this.muc.sbs));
            }
            if (!bi.oW(this.muc.sbt)) {
                g.Ei().DT().a(aa.a.sZk, this.muc.sbt);
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ayn ayn = (ayn) ((b) qVar).dIE.dIL;
        this.uXe = ayn.hUm;
        this.uXf = ayn.hUn;
    }
}
