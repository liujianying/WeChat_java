package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.protocal.p.a;

public final class o extends n {
    public static void atx() {
        g.Eh().dpP.a(new o(), 0);
    }

    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
    }

    protected final oj i(q qVar) {
        return ((a) qVar).qCO.qWR;
    }

    public final int getType() {
        return 722;
    }

    protected final q ccA() {
        a aVar = new a();
        a aVar2 = aVar.qCN;
        aVar2.eK(0);
        aVar2.qWO.rxE.rxC.rsF.addAll(this.qCJ);
        return aVar;
    }
}
