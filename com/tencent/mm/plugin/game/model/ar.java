package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ar extends l implements k {
    private e diJ;
    public final b ivx;

    public ar(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        a aVar = new a();
        aVar.dIG = new xz();
        aVar.dIH = new ya();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        aVar.dIF = 1328;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        xz xzVar = (xz) this.ivx.dID.dIL;
        xzVar.jRj = str;
        xzVar.rDP = linkedList;
        xzVar.rDI = linkedList2;
        xzVar.rDQ = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1328;
    }
}
