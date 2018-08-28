package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.ProductScrollView.a;

final class ProductUI$b {
    int JP;
    private a mJA = new 1(this);
    final /* synthetic */ ProductUI mJt;
    ProductScrollView mJy = ((ProductScrollView) this.mJt.findViewById(R.h.pruduct_root_sv));
    boolean mJz;

    public ProductUI$b(ProductUI productUI) {
        this.mJt = productUI;
        this.mJy.setOnScrollListener(this.mJA);
        this.JP = ProductUI.u(this.mJt);
    }
}
