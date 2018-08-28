package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.tp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class j$1 extends c<tp> {
    final /* synthetic */ j iid;

    j$1(j jVar) {
        this.iid = jVar;
        this.sFo = tp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tp tpVar = (tp) bVar;
        switch (tpVar.cfo.bIH) {
            case 1:
                this.iid.ihY.addAll(bi.F(tpVar.cfo.cfp));
                this.iid.ihZ.addAll(this.iid.ihY);
                this.iid.aEE();
                break;
        }
        return false;
    }
}
