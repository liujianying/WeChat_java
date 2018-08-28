package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private b diG = null;
    private e diJ = null;
    public bbz kru = null;
    private bca krv = null;

    public h(int i, long j, long j2) {
        a aVar = new a();
        aVar.dIG = new bbz();
        aVar.dIH = new bca();
        aVar.dIF = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        long currentTimeMillis = System.currentTimeMillis();
        this.kru = (bbz) this.diG.dID.dIL;
        this.kru.rxG = i;
        this.kru.rxH = j;
        this.kru.seh = j2;
        this.kru.see = currentTimeMillis;
        x.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 824;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krv = (bca) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
