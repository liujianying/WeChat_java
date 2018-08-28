package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.protocal.c.acx;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ae extends l implements k {
    private final b diG;
    private e diJ;
    public bda hxl;

    public ae(LinkedList<String> linkedList, int i) {
        a aVar = new a();
        aVar.dIG = new acw();
        aVar.dIH = new acx();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        aVar.dIF = 1382;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        acw acw = (acw) this.diG.dID.dIL;
        acw.rHq = linkedList;
        acw.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.hxl = ((acx) this.diG.dIE.dIL).rHr;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1382;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
