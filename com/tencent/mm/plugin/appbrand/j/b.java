package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Locale;

public final class b extends l implements k {
    private com.tencent.mm.ab.b dFA;
    private e doG;
    private cdh gkz;

    public b() {
        a aVar = new a();
        aVar.dIG = new cdg();
        aVar.dIH = new cdh();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        aVar.dIF = 1170;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dFA = aVar.KT();
    }

    public final int getType() {
        return 1170;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.doG = eVar2;
        return a(eVar, this.dFA, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gkz = (cdh) this.dFA.dIE.dIL;
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.gkz.syT != null) {
            com.tencent.mm.storage.x DT = g.Ei().DT();
            DT.a(aa.a.sVz, Locale.getDefault().getLanguage());
            DT.a(aa.a.sVA, this.gkz.syT.ksB);
            DT.a(aa.a.sVB, this.gkz.syT.syS);
            DT.a(aa.a.sVC, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
