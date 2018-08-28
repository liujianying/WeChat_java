package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.chatting.c.a;

class o$1 extends c<q> {
    final /* synthetic */ o tPD;

    o$1(o oVar) {
        this.tPD = oVar;
        this.sFo = q.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        q qVar = (q) bVar;
        if (this.tPD.bAG != null) {
            if (qVar.bGO.status == 1) {
                a.cwt().post(new 1(this));
            } else {
                a.cwt().post(new 2(this, qVar));
            }
        }
        return false;
    }
}
