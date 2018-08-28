package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class o$10 extends c<st> {
    final /* synthetic */ o oMC;

    o$10(o oVar) {
        this.oMC = oVar;
        this.sFo = st.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        st stVar = (st) bVar;
        if (stVar instanceof st) {
            stVar.cdA.cdB = com.tencent.mm.plugin.voip.b.b.yV(o.a(this.oMC).mState);
            stVar.cdA.cdC = o.c(this.oMC) != null;
            stVar.cdA.cdD = true;
            stVar.cdA.talker = o.d(this.oMC);
        }
        return false;
    }
}
