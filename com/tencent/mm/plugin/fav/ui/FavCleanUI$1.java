package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavCleanUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavCleanUI iYA;

    FavCleanUI$1(FavCleanUI favCleanUI) {
        this.iYA = favCleanUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iYA.finish();
        return true;
    }
}
