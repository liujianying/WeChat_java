package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.g.a.qj;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$2 extends c<qj> {
    final /* synthetic */ e lez;

    e$2(e eVar) {
        this.lez = eVar;
        this.sFo = qj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qj qjVar = (qj) bVar;
        if (l.a(qjVar.caV.caI, d.NP().NR(), qjVar.caV.caX, qjVar.caV.caZ)) {
            qjVar.caV.caY.run();
            qjVar.caW.result = l.b(qjVar.caV.caI, d.NP().NR(), qjVar.caV.caX, qjVar.caV.caZ);
        } else {
            qjVar.caW.result = 1;
        }
        return false;
    }
}
