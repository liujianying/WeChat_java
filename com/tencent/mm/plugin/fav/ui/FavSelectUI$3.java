package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavSelectUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavSelectUI jag;

    FavSelectUI$3(FavSelectUI favSelectUI) {
        this.jag = favSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jag.finish();
        return true;
    }
}
