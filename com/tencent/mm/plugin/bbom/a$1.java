package com.tencent.mm.plugin.bbom;

import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a hek;

    a$1(a aVar) {
        this.hek = aVar;
    }

    public final void run() {
        bf.iH("ver" + d.qVN);
        ao.bmh().cS(a.bmf().cbO());
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.sFg;
        if (aVar == null) {
            x.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
            return;
        }
        gz gzVar = new gz();
        gzVar.bQj.bQk = true;
        aVar.m(gzVar);
        ri riVar = new ri();
        riVar.ccb.ccc = true;
        aVar.m(riVar);
        aVar.m(new dd());
        aVar.m(new kw());
        c.bN(true);
        o.PM().id(3);
        x.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
    }

    public final String toString() {
        return super.toString() + "|onGYNetEnd2";
    }
}
