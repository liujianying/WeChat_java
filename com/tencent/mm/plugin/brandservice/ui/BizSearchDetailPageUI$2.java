package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizSearchDetailPageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BizSearchDetailPageUI hos;

    BizSearchDetailPageUI$2(BizSearchDetailPageUI bizSearchDetailPageUI) {
        this.hos = bizSearchDetailPageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hos.finish();
        return true;
    }
}
