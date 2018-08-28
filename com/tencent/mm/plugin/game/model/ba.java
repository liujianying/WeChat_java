package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ba extends l implements k {
    private String appId;
    private e diJ;
    final b ivx;

    public ba(String str) {
        a aVar = new a();
        aVar.dIG = new als();
        aVar.dIH = new alt();
        aVar.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        aVar.dIF = 1369;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.appId = str;
        this.ivx = aVar.KT();
        als als = (als) this.ivx.dID.dIL;
        als.jRj = w.chP();
        als.eJQ = bi.fS(ad.getContext());
        als.jQb = str;
        x.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[]{als.jRj, als.eJQ, als.jQb});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.diJ.a(i2, i3, str, this);
        } else if (((alt) ((b) qVar).dIE.dIL) == null) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1369;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }
}
