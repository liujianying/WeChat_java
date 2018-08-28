package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private WakerLock cWJ = new WakerLock(ad.getContext(), "MicroMsg.NetSceneSynCheck");
    private final q dJM;
    private e diJ;

    public j() {
        this.cWJ.lock(3000, "NetSceneSynCheck");
        this.dJM = new a();
        g.Ek();
        if (g.Ei() != null) {
            g.Ek();
            if (g.Ei().DT() != null) {
                g.Ek();
                a aVar = (a) this.dJM.KV();
                aVar.dZu = bi.WP((String) g.Ei().DT().get(8195, null));
                a aVar2 = (a) this.dJM.KV();
                g.Ek();
                g.Eg();
                aVar2.uin = com.tencent.mm.kernel.a.Df();
                ((a) this.dJM.KV()).netType = com.tencent.mm.protocal.a.getNetType(ad.getContext());
                ((a) this.dJM.KV()).qWE = com.tencent.mm.protocal.a.cfW();
                x.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                return;
            }
        }
        x.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        int a = a(eVar, this.dJM, this);
        if (a == -1 && this.cWJ.isLocking()) {
            this.cWJ.unLock();
        }
        return a;
    }

    public final boolean KX() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        b bVar = (b) qVar.Id();
        x.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.qXc);
        if (g.Eg().Dx() && !com.tencent.mm.kernel.a.Dr()) {
            byte[] bArr2 = ((a) qVar.KV()).dpW;
            if (bi.bC(bArr2)) {
                x.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.dpW = bArr2;
            ((com.tencent.mm.plugin.zero.b.b) g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(bVar.qXc, 2, bVar.cgq());
        }
        this.diJ.a(i2, i3, str, this);
        this.cWJ.unLock();
    }
}
