package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class av$2 extends c<qn> {
    final /* synthetic */ av ocj;

    av$2(av avVar) {
        this.ocj = avVar;
        this.sFo = qn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qn qnVar = (qn) bVar;
        if (qnVar instanceof qn) {
            String str = qnVar.cbc.id;
            if (qnVar.cbc.type == 1) {
                av.c(this.ocj, str);
            } else if (qnVar.cbc.type == 2) {
                av.d(this.ocj, qnVar.cbc.id);
            }
        }
        return false;
    }
}
