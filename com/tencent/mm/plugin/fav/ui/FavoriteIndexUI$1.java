package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavoriteIndexUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$1(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FavoriteIndexUI.a(this.jbh).jbI) {
            FavoriteIndexUI.b(this.jbh);
        } else {
            this.jbh.finish();
        }
        return true;
    }
}
