package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.sdk.platformtools.x;

public final class at extends l implements k {
    private e diJ;
    public final b ivx;

    public at(String str, String str2, boolean z) {
        a aVar = new a();
        aVar.dIG = new ay();
        aVar.dIH = new az();
        aVar.uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
        aVar.dIF = 1217;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        ay ayVar = (ay) this.ivx.dID.dIL;
        ayVar.jRj = str;
        ayVar.jPc = str2;
        ayVar.jRt = z;
        ayVar.jRv = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1217;
    }
}
