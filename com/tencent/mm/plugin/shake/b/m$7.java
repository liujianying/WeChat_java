package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class m$7 extends c<rg> {
    final /* synthetic */ m mXg;

    m$7(m mVar) {
        this.mXg = mVar;
        this.sFo = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rg rgVar = (rg) bVar;
        if (rgVar.cbZ.cca.equals(ph.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                this.mXg.mXb.adc();
            } else {
                this.mXg.mXb.unregister();
            }
        }
        return false;
    }
}
