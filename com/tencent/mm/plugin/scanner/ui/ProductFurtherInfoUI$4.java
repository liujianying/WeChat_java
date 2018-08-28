package com.tencent.mm.plugin.scanner.ui;

import android.support.v4.view.ViewPager.e;

class ProductFurtherInfoUI$4 implements e {
    final /* synthetic */ ProductFurtherInfoUI mIE;

    ProductFurtherInfoUI$4(ProductFurtherInfoUI productFurtherInfoUI) {
        this.mIE = productFurtherInfoUI;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        if (ProductFurtherInfoUI.b(this.mIE).getParent() != null) {
            ProductFurtherInfoUI.b(this.mIE).getParent().requestDisallowInterceptTouchEvent(true);
        }
        ProductFurtherInfoUI.c(this.mIE).setPage(i);
    }

    public final void N(int i) {
    }
}
