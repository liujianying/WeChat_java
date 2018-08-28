package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$3 extends c<rg> {
    final /* synthetic */ c jFM;

    c$3(c cVar) {
        this.jFM = cVar;
        this.sFo = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rg rgVar = (rg) bVar;
        if (rgVar.cbZ.cca.equals(gp.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                this.jFM.jFE.adc();
            } else {
                this.jFM.jFE.unregister();
            }
        }
        return false;
    }
}
