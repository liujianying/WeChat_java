package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottlePersonalInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BottlePersonalInfoUI hlw;

    BottlePersonalInfoUI$1(BottlePersonalInfoUI bottlePersonalInfoUI) {
        this.hlw = bottlePersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hlw.finish();
        return true;
    }
}
