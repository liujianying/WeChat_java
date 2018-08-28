package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.e.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements com.tencent.d.b.e.e, k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    private com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> jgZ = null;

    public final /* synthetic */ void bx(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.dIG = new bvf();
        aVar2.dIH = new bvg();
        aVar2.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar2.dIF = 619;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        bvf bvf = (bvf) this.diG.dID.dIL;
        bvf.otY = 619;
        bvf.srU = aVar.vmd;
        bvf.srV = aVar.vmc;
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", aVar.vmc, aVar.vmd);
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
    }

    public final int getType() {
        return 619;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.jgZ != null) {
                this.jgZ.cG(new com.tencent.d.b.e.e.b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.jgZ != null) {
            this.jgZ.cG(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void a(com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> bVar) {
        this.jgZ = bVar;
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        g.DF().a((l) this, 0);
    }
}
