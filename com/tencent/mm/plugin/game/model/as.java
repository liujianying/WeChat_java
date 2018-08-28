package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class as extends l implements k {
    public String bHt;
    private e diJ;
    public final b ivx;

    public as(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new xw();
        aVar.dIH = new xx();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        aVar.dIF = 1329;
        aVar.dII = 0;
        aVar.dIJ = 0;
        if (str2 == null) {
            this.bHt = "";
        } else {
            this.bHt = str2.trim();
        }
        this.ivx = aVar.KT();
        xw xwVar = (xw) this.ivx.dID.dIL;
        xwVar.jRj = str;
        xwVar.rDH = str2;
        xwVar.rDI = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1329;
    }
}
