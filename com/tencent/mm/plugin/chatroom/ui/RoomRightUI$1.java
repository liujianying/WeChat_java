package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomRightUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomRightUI hNL;

    RoomRightUI$1(RoomRightUI roomRightUI) {
        this.hNL = roomRightUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hNL.YC();
        this.hNL.finish();
        return true;
    }
}
