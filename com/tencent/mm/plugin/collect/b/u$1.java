package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.g;

class u$1 implements e {
    final /* synthetic */ op hUN;
    final /* synthetic */ u hUO;

    u$1(u uVar, op opVar) {
        this.hUO = uVar;
        this.hUN = opVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.hUO.eBX != null && this.hUO.eBX.isShowing()) {
            this.hUO.eBX.dismiss();
            this.hUO.eBX = null;
        }
        g.DF().b(1800, this);
        k kVar = (k) lVar;
        kVar.a(new 3(this)).b(new 2(this, kVar)).c(new 1(this));
        this.hUN.bZx.bJX.run();
    }
}
