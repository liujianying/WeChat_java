package com.tencent.mm.plugin.fav.ui;

import android.support.v4.view.m.e;
import android.view.MenuItem;

class FavSearchUI$5 implements e {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$5(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }

    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        this.iZQ.finish();
        return true;
    }
}
