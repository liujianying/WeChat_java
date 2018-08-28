package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.to;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.wear.model.f.h;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$3 extends c<to> {
    final /* synthetic */ e pJo;

    e$3(e eVar) {
        this.pJo = eVar;
        this.sFo = to.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        to toVar = (to) bVar;
        switch (toVar.cfd.action) {
            case 2:
                a.bSl().pIS.a(new h(toVar.cfe.bIZ, toVar.cfe.cfh, toVar.cfe.cfi, toVar.cfe.cfj));
                break;
            case 4:
                if (g.AT().getInt("WearPayBlock", 0) == 0) {
                    a.bSl().pIS.a(new k(toVar.cfd.cff, toVar.cfd.content));
                    break;
                }
                break;
        }
        return false;
    }
}
