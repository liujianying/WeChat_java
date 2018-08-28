package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.sdk.platformtools.x;

public final class bb extends l implements k {
    private e diJ;
    private final b ivx;

    public bb(String str, int i, int i2, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new at();
        aVar.dIH = new au();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        aVar.dIF = 1223;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        at atVar = (at) this.ivx.dID.dIL;
        atVar.jPc = str;
        atVar.jRb = i;
        atVar.jRc = i2;
        atVar.jRd = str2;
        atVar.jRe = str3;
        atVar.jRa = (int) (System.currentTimeMillis() / 1000);
    }

    public final int getType() {
        return 1223;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
