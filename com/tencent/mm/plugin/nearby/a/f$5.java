package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class f$5 extends c<rg> {
    final /* synthetic */ f lBu;

    f$5(f fVar) {
        this.lBu = fVar;
        this.sFo = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rg rgVar = (rg) bVar;
        if (rgVar.cbZ.cca.equals(jz.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                this.lBu.lBq.cbp();
            } else {
                this.lBu.lBq.aYG();
            }
        } else if (rgVar.cbZ.cca.equals(ka.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                this.lBu.lBr.cbp();
            } else {
                this.lBu.lBr.aYG();
            }
        } else if (rgVar.cbZ.cca.equals(iq.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                this.lBu.lBs.adc();
            } else {
                this.lBu.lBs.unregister();
            }
        }
        return false;
    }
}
