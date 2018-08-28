package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends l implements k {
    public b diG;
    private e diJ;

    public ag(int i, String str) {
        a aVar = new a();
        aVar.dIG = new art();
        aVar.dIH = new aru();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        aVar.dIF = 1060;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        art art = (art) this.diG.dID.dIL;
        art.offset = i;
        art.limit = 20;
        art.lang = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1060;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        return a(eVar, this.diG, this);
    }
}
