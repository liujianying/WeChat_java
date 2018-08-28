package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SearchBarUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SearchBarUI tpV;

    SearchBarUI$2(SearchBarUI searchBarUI) {
        this.tpV = searchBarUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tpV.finish();
        return true;
    }
}
