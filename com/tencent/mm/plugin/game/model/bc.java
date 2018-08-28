package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.sdk.platformtools.x;

public final class bc extends l implements k {
    private e diJ;
    final b ivx;

    public bc(int i, int i2) {
        x.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.dIG = new bjf();
        aVar.dIH = new bjg();
        aVar.uri = "/cgi-bin/mmgame-bin/searchgamelist";
        aVar.dIF = 1215;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        bjf bjf = (bjf) this.ivx.dID.dIL;
        bjf.jSa = i;
        bjf.jSb = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchGameList", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1215;
    }
}
