package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bci;
import com.tencent.mm.protocal.c.bcj;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private b diG = null;
    private e diJ = null;
    public bci krG = null;
    private bcj krH = null;

    public n(int i, long j, long j2, int i2) {
        a aVar = new a();
        aVar.dIG = new bci();
        aVar.dIH = new bcj();
        aVar.dIF = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        long currentTimeMillis = System.currentTimeMillis();
        this.krG = (bci) this.diG.dID.dIL;
        this.krG.jTv = q.GF();
        this.krG.rxG = i;
        this.krG.rxH = j;
        this.krG.seh = j2;
        this.krG.hcd = i2;
        this.krG.see = currentTimeMillis;
        x.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 723;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krH = (bcj) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
