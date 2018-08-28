package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.g.a.qm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$1 extends c<qm> {
    final /* synthetic */ b nxz;

    b$1(b bVar) {
        this.nxz = bVar;
        this.sFo = qm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qm qmVar = (qm) bVar;
        if (qmVar instanceof qm) {
            x.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + this.nxz.nvC);
            if (this.nxz.nvC != -1 && this.nxz.nvC < 0) {
                Iterator it = qmVar.cba.cbb.iterator();
                while (it.hasNext()) {
                    if (((Long) it.next()).longValue() > this.nxz.nvC) {
                        b bVar2 = this.nxz;
                        bVar2.nvN++;
                    }
                }
            }
        }
        return false;
    }
}
