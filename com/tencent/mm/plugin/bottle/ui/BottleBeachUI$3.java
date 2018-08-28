package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleBeachUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BottleBeachUI hkL;

    BottleBeachUI$3(BottleBeachUI bottleBeachUI) {
        this.hkL = bottleBeachUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hkL.YC();
        this.hkL.finish();
        return false;
    }
}
