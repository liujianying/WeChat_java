package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ay extends l implements k {
    private e diJ;
    public final b ivx;

    public ay(int i, LinkedList<String> linkedList, int i2, boolean z) {
        a aVar = new a();
        aVar.dIG = new bk();
        aVar.dIH = new bl();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetlibgamelist";
        aVar.dIF = 1218;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        bk bkVar = (bk) this.ivx.dID.dIL;
        bkVar.jSa = i;
        bkVar.jSb = 15;
        bkVar.jRj = w.chP();
        bkVar.eJQ = bi.fS(ad.getContext());
        bkVar.jSc = i2;
        bkVar.jRK = linkedList;
        bkVar.jSd = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLibGameList", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1218;
    }
}
