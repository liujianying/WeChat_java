package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductFurtherInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ProductFurtherInfoUI mIE;

    ProductFurtherInfoUI$1(ProductFurtherInfoUI productFurtherInfoUI) {
        this.mIE = productFurtherInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mIE.finish();
        return false;
    }
}
