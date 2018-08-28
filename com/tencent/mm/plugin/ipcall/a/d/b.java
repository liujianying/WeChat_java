package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG = null;
    private e diJ;
    private bbx krh = null;
    public bby kri = null;

    public b(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.dIG = new bbx();
        aVar.dIH = new bby();
        aVar.dIF = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.krh = (bbx) this.diG.dID.dIL;
        this.krh.sei = str;
        this.krh.sek = str2;
        this.krh.sem = str3;
        this.krh.sel = str4;
        this.krh.sen = i;
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[]{str, str2, str3, str4, Integer.valueOf(i)});
    }

    public final int getType() {
        return 807;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.kri = (bby) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
