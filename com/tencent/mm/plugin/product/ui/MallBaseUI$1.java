package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallBaseUI lSf;

    MallBaseUI$1(MallBaseUI mallBaseUI) {
        this.lSf = mallBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lSf.finish();
        return true;
    }
}
