package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.protocal.c.caq;
import com.tencent.mm.protocal.c.car;

public final class k extends n<caq, car> {
    public k(bqp bqp) {
        a aVar = new a();
        aVar.dIG = new caq();
        aVar.dIH = new car();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        aVar.dIF = 765;
        aVar.dII = 765;
        aVar.dIJ = 1000000765;
        this.diG = aVar.KT();
        caq caq = (caq) this.diG.dID.dIL;
        caq.rxG = bqp.rxG;
        caq.soz = bqp.soz;
        caq.rth = bqp.rth;
        caq.soA = bqp.soA;
        caq.soB = bqp.soB;
        caq.soC = bqp.soC;
        caq.soD = bqp.soD;
        caq.soE = bqp.soE;
        caq.soF = bqp.soF;
        caq.soG = bqp.soG;
        caq.soH = bqp.soH;
        caq.soI = bqp.soI;
        caq.soJ = bqp.soJ;
    }

    public final int getType() {
        return 765;
    }

    public final e bLm() {
        return new 1(this);
    }
}
