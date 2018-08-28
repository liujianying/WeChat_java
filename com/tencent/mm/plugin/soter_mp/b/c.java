package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bwm;
import com.tencent.mm.protocal.c.bwn;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends d implements e, k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private com.tencent.d.b.e.b<e.b> jgZ = null;

    public final /* synthetic */ void bx(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.dIG = new bwm();
        aVar2.dIH = new bwn();
        aVar2.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar2.dIF = 1185;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        bwm bwm = (bwm) this.diG.dID.dIL;
        bwm.ssM = aVar.vmc;
        bwm.ssN = aVar.vmd;
    }

    public final int getType() {
        return 1185;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
        if (this.jgZ == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.jgZ.cG(new e.b(true));
        } else {
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void aNJ() {
        x.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
        if (this.jgZ != null) {
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void pS(int i) {
        x.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i)});
        if (this.diJ != null) {
            this.diJ.a(4, -1, "", this);
        }
    }

    public final void execute() {
        g.DF().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.jgZ = bVar;
    }
}
