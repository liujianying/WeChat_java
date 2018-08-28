package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavTagEditUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavTagEditUI jaA;

    FavTagEditUI$1(FavTagEditUI favTagEditUI) {
        this.jaA = favTagEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FavTagEditUI.a(this.jaA);
        return true;
    }
}
