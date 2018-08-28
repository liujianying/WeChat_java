package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteTextDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteTextDetailUI jdz;

    FavoriteTextDetailUI$1(FavoriteTextDetailUI favoriteTextDetailUI) {
        this.jdz = favoriteTextDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jdz.finish();
        return true;
    }
}
