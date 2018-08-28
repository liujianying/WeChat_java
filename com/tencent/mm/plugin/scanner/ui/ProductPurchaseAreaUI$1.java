package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductPurchaseAreaUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ProductPurchaseAreaUI mIR;

    ProductPurchaseAreaUI$1(ProductPurchaseAreaUI productPurchaseAreaUI) {
        this.mIR = productPurchaseAreaUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mIR.finish();
        return false;
    }
}
