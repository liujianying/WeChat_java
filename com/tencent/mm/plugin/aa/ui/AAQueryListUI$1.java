package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AAQueryListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$1(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eCd.finish();
        return false;
    }
}
