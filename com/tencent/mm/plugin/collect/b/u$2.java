package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.wallet_core.c.h.a;

class u$2 implements e {
    final /* synthetic */ op hUN;
    final /* synthetic */ u hUO;

    u$2(u uVar, op opVar) {
        this.hUO = uVar;
        this.hUN = opVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.hUO.eBX != null && this.hUO.eBX.isShowing()) {
            this.hUO.eBX.dismiss();
            this.hUO.eBX = null;
        }
        g.DF().b(2811, this);
        final c cVar = (c) lVar;
        cVar.a(new 3(this)).b(new a() {
            public final void g(int i, int i2, String str, l lVar) {
                u$2.this.hUN.bZy.Yy = cVar.hUZ.hUn;
            }
        }).c(new 1(this));
        this.hUN.bZx.bJX.run();
    }
}
