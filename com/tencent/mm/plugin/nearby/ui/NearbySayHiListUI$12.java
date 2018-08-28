package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbySayHiListUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$12(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lCB.YC();
        this.lCB.setResult(0);
        this.lCB.finish();
        return true;
    }
}
