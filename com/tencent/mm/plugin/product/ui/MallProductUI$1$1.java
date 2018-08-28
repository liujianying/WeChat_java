package com.tencent.mm.plugin.product.ui;

import android.widget.ScrollView;
import com.tencent.mm.plugin.product.ui.MallProductUI.1;
import com.tencent.mm.plugin.wxpay.a.f;

class MallProductUI$1$1 implements Runnable {
    final /* synthetic */ 1 lUb;

    MallProductUI$1$1(1 1) {
        this.lUb = 1;
    }

    public final void run() {
        ScrollView scrollView = (ScrollView) this.lUb.lUa.findViewById(f.mall_product_sv);
        if (scrollView != null) {
            scrollView.pageScroll(33);
        }
    }
}
