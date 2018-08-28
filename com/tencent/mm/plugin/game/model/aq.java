package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class aq extends l implements k {
    public static final String jOw = (b.bnE + "Game/TabNav/");
    private e diJ;
    final com.tencent.mm.ab.b ivx;

    public aq() {
        a aVar = new a();
        aVar.dIG = new be();
        aVar.dIH = new bf();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
        aVar.dIF = 2641;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.diJ.a(i2, i3, str, this);
        } else if (((bf) ((com.tencent.mm.ab.b) qVar).dIE.dIL) == null) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 2641;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public static void a(a aVar) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data");
        g.DF().a(2641, new 1(aVar));
        g.DF().a(new aq(), 0);
    }

    private static void a(List<String> list, b bVar) {
        while (!bi.cX(list)) {
            String str = (String) list.remove(0);
            if (bi.oW(str)) {
                x.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
            } else {
                String str2 = jOw + com.tencent.mm.a.g.u(str.getBytes());
                c.a aVar = new c.a();
                aVar.dXy = true;
                aVar.dXA = str2;
                o.Pj().a(str, aVar.Pt(), new 3(str, list, bVar));
                return;
            }
        }
        if (bVar != null) {
            bVar.onComplete();
        }
    }
}
