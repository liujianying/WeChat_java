package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectMainUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$14(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hYN.finish();
        return true;
    }
}
