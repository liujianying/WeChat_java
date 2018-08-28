package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.scanner.a.c;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.sdk.platformtools.x;

class ProductUI$1 implements a$a {
    final /* synthetic */ ProductUI mJt;

    ProductUI$1(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            x.i("MicroMsg.scanner.ProductUI", "getLocation suc");
            if (ProductUI.a(this.mJt) != null) {
                x.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                au.DF().a(new c(ProductUI.b(this.mJt), k.bY(ProductUI.a(this.mJt).mNX), ProductUI.c(this.mJt), ProductUI.d(this.mJt), (double) f, (double) f2), 0);
            }
            if (ProductUI.e(this.mJt) != null) {
                ProductUI.e(this.mJt).c(ProductUI.f(this.mJt));
            }
            if (!ProductUI.g(this.mJt)) {
                ProductUI.h(this.mJt);
                o.a(2011, f, f2, (int) d2);
            }
            return false;
        }
        x.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        return false;
    }
}
