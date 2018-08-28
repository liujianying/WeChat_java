package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.List;

public final class q extends l implements k {
    private final b diG;
    private e diJ;

    public q(List<apz> list) {
        a aVar = new a();
        aVar.dIG = new apl();
        aVar.dIH = new apm();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        aVar.dIF = 1803;
        this.diG = aVar.KT();
        apl apl = (apl) this.diG.dID.dIL;
        apy apy = new apy();
        apy.rjL = d.qVI;
        apy.rjM = d.qVH;
        apy.rjN = d.qVK;
        apy.rjO = d.qVL;
        apy.rjP = w.chP();
        apy.rSA = (int) (System.currentTimeMillis() / 1000);
        apl.rbM = apy;
        apl.rbN.addAll(list);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            apm apm = (apm) ((b) qVar).dIE.dIL;
            x.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (bi.cX(apm.rSm)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = apm.rSm.iterator();
                while (it.hasNext()) {
                    ant ant = (ant) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(ant.rQv), Integer.valueOf(ant.rQw)}));
                }
            }
            stringBuilder.append(" }");
            x.i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            f.a.bTW();
            f.cM(apm.rSm);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.d("MicroMsg.NetSceneJsLog", "doScene");
        return a(eVar, this.diG, this);
    }
}
