package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ProductUI$5 extends c<jt> {
    final /* synthetic */ ProductUI mJt;

    ProductUI$5(ProductUI productUI) {
        this.mJt = productUI;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((jt) bVar).bTE.action) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                if (this.mJt.eOE != null) {
                    ProductUI.o(this.mJt);
                    break;
                }
                break;
        }
        return false;
    }
}
