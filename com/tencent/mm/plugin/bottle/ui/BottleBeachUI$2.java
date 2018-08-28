package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleBeachUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BottleBeachUI hkL;

    BottleBeachUI$2(BottleBeachUI bottleBeachUI) {
        this.hkL = bottleBeachUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.hkL, BottlePersonalInfoUI.class);
        intent.putExtra("is_allow_set", false);
        this.hkL.startActivity(intent);
        return false;
    }
}
