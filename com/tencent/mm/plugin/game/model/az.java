package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class az extends l implements k {
    private e diJ;
    public final b ivx;

    public az(int i, int i2, int i3) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(15), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.dIG = new bm();
        aVar.dIH = new bn();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
        aVar.dIF = 1220;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        bm bmVar = (bm) this.ivx.dID.dIL;
        bmVar.jSa = i;
        bmVar.jSb = 15;
        bmVar.jRj = w.chP();
        bmVar.jSi = i2;
        bmVar.jSj = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1220;
    }
}
