package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomUpgradeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomUpgradeUI hOi;

    RoomUpgradeUI$1(RoomUpgradeUI roomUpgradeUI) {
        this.hOi = roomUpgradeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hOi.finish();
        return true;
    }
}
