package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.g.a.te;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$3 extends c<te> {
    final /* synthetic */ f lSK;

    f$3(f fVar) {
        this.lSK = fVar;
        this.sFo = te.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        te teVar = (te) bVar;
        if (teVar instanceof te) {
            if (teVar.ceH.result != -1) {
                x.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
            } else if (!f.e(this.lSK)) {
                x.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                f.f(this.lSK);
                f.g(this.lSK);
            }
            return true;
        }
        x.f("MicroMsg.MallProductUI", "mismatched event");
        return false;
    }
}
