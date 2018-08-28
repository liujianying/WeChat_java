package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$3 implements Runnable {
    final /* synthetic */ ProductUI mJt;
    final /* synthetic */ a mJu;

    ProductUI$3(ProductUI productUI, a aVar) {
        this.mJt = productUI;
        this.mJu = aVar;
    }

    public final void run() {
        ProductUI.a(this.mJt, this.mJu);
        ProductUI.b(this.mJt, this.mJu);
    }
}
