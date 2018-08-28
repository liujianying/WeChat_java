package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ProductUI mJt;

    ProductUI$10(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (ProductUI.c(this.mJt) == 4) {
            this.mJt.setResult(0);
        }
        this.mJt.finish();
        return true;
    }
}
