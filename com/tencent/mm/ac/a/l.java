package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.ab.l implements k {
    private Object data;
    public b diG;
    private e diJ;

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new hx();
        aVar.dIH = new hy();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        aVar.dIF = 1364;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        hx hxVar = (hx) this.diG.dID.dIL;
        hxVar.riK = str;
        hxVar.bHt = str2;
        hxVar.offset = i;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1364;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        return a(eVar, this.diG, this);
    }
}
