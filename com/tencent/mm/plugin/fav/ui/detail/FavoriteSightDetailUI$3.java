package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteSightDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$3(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.jdp = favoriteSightDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jdp.finish();
        return true;
    }
}
