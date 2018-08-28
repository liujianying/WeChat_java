package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b diG = null;
    private e diJ = null;
    public bbv krf = null;
    private bbw krg = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bbv();
        aVar.dIH = new bbw();
        aVar.dIF = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        long currentTimeMillis = System.currentTimeMillis();
        this.krf = (bbv) this.diG.dID.dIL;
        this.krf.rxG = i;
        this.krf.rxH = j;
        this.krf.jTu = str;
        this.krf.see = currentTimeMillis;
        this.krf.sef = i2;
        this.krf.seg = str2;
        this.krf.seh = j2;
        x.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2)});
    }

    public final int getType() {
        return 843;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krg = (bbw) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
