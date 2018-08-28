package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends d implements k {
    public final b diG;
    private e diJ;
    public String jgX = "";
    public boolean jgY = false;

    public a() {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bqi();
        aVar.dIH = new bqj();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.dIF = 1586;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bqi bqi = (bqi) this.diG.dID.dIL;
        c bFh = com.tencent.mm.plugin.soter.c.b.bFh();
        x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[]{bFh.onE, bFh.onF});
        bqi.onE = r2;
        bqi.onF = r1;
        bqi.scene = 0;
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            boolean z;
            bqj bqj = (bqj) ((b) qVar).dIE.dIL;
            this.jgX = bqj.jgX;
            s.pqR.jgX = this.jgX;
            this.jgY = 1 == bqj.soi;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == bqj.soi) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str2, str3, objArr);
            s.pqR.jgY = this.jgY;
            x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[]{this.jgX, Boolean.valueOf(this.jgY)});
        }
        this.diJ.a(i, i2, str, this);
    }

    public final void aNJ() {
        x.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final void pS(int i) {
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }
}
