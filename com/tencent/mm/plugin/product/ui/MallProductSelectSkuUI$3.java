package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.a;
import com.tencent.mm.plugin.wxpay.a$i;

class MallProductSelectSkuUI$3 implements a {
    final /* synthetic */ MallProductSelectSkuUI lTq;

    MallProductSelectSkuUI$3(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.lTq = mallProductSelectSkuUI;
    }

    public final void ex(int i) {
        MallProductSelectSkuUI.b(this.lTq).mCount = i;
        MallProductSelectSkuUI.c(this.lTq).setVisibility(8);
    }

    public final void dk(int i, int i2) {
        switch (i2) {
            case 1:
                MallProductSelectSkuUI.c(this.lTq).setText(a$i.mall_product_select_sku_amount_err);
                MallProductSelectSkuUI.c(this.lTq).setVisibility(0);
                return;
            case 3:
                MallProductSelectSkuUI.c(this.lTq).setText(this.lTq.getString(a$i.mall_product_select_sku_amount_limit_err, new Object[]{Integer.valueOf(i)}));
                MallProductSelectSkuUI.c(this.lTq).setVisibility(0);
                return;
            default:
                return;
        }
    }
}
