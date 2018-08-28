package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.kl;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$9 extends c<kl> {
    final /* synthetic */ e pJo;

    e$9(e eVar) {
        this.pJo = eVar;
        this.sFo = kl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kl klVar = (kl) bVar;
        if (e.a(this.pJo)) {
            a.bSl().pIS.a(new f(klVar.bUL.userName, klVar.bUL.bgn, klVar.bUL.type));
        }
        return false;
    }
}
