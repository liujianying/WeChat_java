package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    private b diG = null;
    private e diJ;
    private bcg krC = null;
    private bch krD = null;

    public l(int i, long j, boolean z) {
        a aVar = new a();
        aVar.dIG = new bcg();
        aVar.dIH = new bch();
        aVar.dIF = 227;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krC = (bcg) this.diG.dID.dIL;
        this.krC.rxG = i;
        this.krC.seh = j;
        this.krC.seB = z ? 1 : 0;
        x.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[]{Integer.valueOf(this.krC.rxG), Long.valueOf(this.krC.seh), Integer.valueOf(this.krC.seB)});
        bcg bcg = this.krC;
        com.tencent.mm.plugin.ipcall.a.c.b aXr = i.aXr();
        x.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[]{aXr.kpo + "," + aXr.kpp + "," + aXr.kqO + "," + aXr.eNQ + "," + aXr.kqP + "," + aXr.kqE + "," + aXr.kqF + "," + aXr.kqG + "," + aXr.kqH + "," + aXr.kqI + "," + aXr.kqJ + "," + aXr.kqK + "," + aXr.kqL + "," + aXr.kqM + "," + aXr.kqN + "," + aXr.kqQ + "," + c.aYA() + "," + aXr.kqZ + "," + aXr.countryCode + "," + aXr.kra + "," + aXr.krb + "," + aXr.krc + aXr.kqX + "," + aXr.kre});
        bcg.sey = ab.oT(r3);
        bcg = this.krC;
        aXr = i.aXr();
        x.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[]{aXr.kpo + "," + aXr.kpp + "," + aXr.kqO + aXr.kqW});
        bcg.sez = ab.oT(r3);
        bcg = this.krC;
        aXr = i.aXr();
        x.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[]{aXr.kpo + "," + aXr.kpp + "," + aXr.kqO + aXr.kqV});
        bcg.seA = ab.oT(r3);
    }

    public final int getType() {
        return 227;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krD = (bch) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
