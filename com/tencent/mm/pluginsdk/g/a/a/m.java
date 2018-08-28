package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends n {
    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    protected final oj i(q qVar) {
        return (oj) ((b) qVar).dIE.dIL;
    }

    public m(int i) {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[]{Integer.valueOf(i)});
        bho bho = new bho();
        bho.hcE = i;
        this.qCJ.clear();
        this.qCJ.add(bho);
    }

    protected final q ccA() {
        a aVar = new a();
        oi oiVar = new oi();
        oiVar.rsF.addAll(this.qCJ);
        aVar.dIG = oiVar;
        aVar.dIH = new oj();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.dIF = 721;
        aVar.dII = 0;
        aVar.dIJ = 0;
        return aVar.KT();
    }

    public final int getType() {
        return 721;
    }
}
