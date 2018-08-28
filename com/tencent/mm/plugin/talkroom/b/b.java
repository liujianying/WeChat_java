package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    private int sceneType;

    public b(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.dIG = new uf();
        aVar.dIH = new ug();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.dIF = 333;
        aVar.dII = 148;
        aVar.dIJ = 1000000148;
        this.diG = aVar.KT();
        uf ufVar = (uf) this.diG.dID.dIL;
        ufVar.rxF = str;
        ufVar.rxG = i;
        ufVar.rxH = j;
        ufVar.otY = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.sceneType)});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
