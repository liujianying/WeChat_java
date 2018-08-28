package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class av$3 extends c<qp> {
    final /* synthetic */ av ocj;

    av$3(av avVar) {
        this.ocj = avVar;
        this.sFo = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        if (qpVar instanceof qp) {
            String str = qpVar.cbf.id;
            if (qpVar.cbf.type == 1) {
                av.e(this.ocj, str);
            } else if (qpVar.cbf.type == 2) {
                av.f(this.ocj, str);
            }
        }
        return false;
    }
}
