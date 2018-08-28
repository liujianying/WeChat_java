package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.sdk.platformtools.x;

public final class bd extends l implements k {
    private e diJ;
    public final b ivx;

    public bd(String str, String str2, String str3, boolean z) {
        a aVar = new a();
        aVar.dIG = new dc();
        aVar.dIH = new dd();
        aVar.uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
        aVar.dIF = 1219;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        dc dcVar = (dc) this.ivx.dID.dIL;
        dcVar.jPc = str;
        dcVar.jRj = str2;
        dcVar.jOZ = str3;
        dcVar.jPp = z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSubscription", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1219;
    }
}
