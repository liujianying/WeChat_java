package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bck;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    private b diG = null;
    private e diJ;
    public bck krI = null;
    public bcl krJ = null;

    public o(int i, long j, int i2, long j2, boolean z) {
        a aVar = new a();
        aVar.dIG = new bck();
        aVar.dIH = new bcl();
        aVar.dIF = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        long currentTimeMillis = System.currentTimeMillis();
        this.krI = (bck) this.diG.dID.dIL;
        this.krI.seC = q.GF();
        this.krI.rxG = i;
        this.krI.rxH = j;
        this.krI.see = currentTimeMillis;
        this.krI.seD = i2;
        this.krI.seh = j2;
        if (z) {
            this.krI.seE = 1;
        } else {
            this.krI.seE = 0;
        }
        x.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.krI.seE), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 819;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krJ = (bcl) ((b) qVar).dIE.dIL;
        this.diJ.a(i2, i3, str, this);
    }
}
