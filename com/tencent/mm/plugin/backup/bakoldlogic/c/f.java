package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private final b diG;
    private e diJ;

    public f(String str) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[]{str, bi.cjd()});
        a aVar = new a();
        aVar.dIG = new acg();
        aVar.dIH = new ach();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.dIF = 595;
        this.diG = aVar.KT();
        ((acg) this.diG.dID.dIL).URL = str;
    }

    public final int getType() {
        return 595;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final ach atg() {
        return (ach) this.diG.dIE.dIL;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ach ach = (ach) this.diG.dIE.dIL;
            d.X(ach.reV.siK.lR);
            x.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[]{ach.ID, ach.rfr, ach.rfs, ach.rfj, ach.rfk, Integer.valueOf(ach.otY)});
            x.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[]{ach.rGT});
            com.tencent.mm.bk.b bVar = ach.reV.siK;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
