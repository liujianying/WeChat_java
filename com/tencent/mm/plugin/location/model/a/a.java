package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public final b diG;
    private e diJ;
    private Runnable egq;

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new uh();
        aVar.dIH = new ui();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.dIF = 491;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((uh) this.diG.dID.dIL).rxQ = str;
        x.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + str);
    }

    public final int getType() {
        return 491;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (this.egq != null) {
            this.egq.run();
        }
    }
}
