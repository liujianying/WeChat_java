package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallIndexMenuUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexMenuUI kZx;

    MallIndexMenuUI$1(MallIndexMenuUI mallIndexMenuUI) {
        this.kZx = mallIndexMenuUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kZx.finish();
        return true;
    }
}
