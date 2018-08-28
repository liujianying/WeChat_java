package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ManageChatroomUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ManageChatroomUI hMS;

    ManageChatroomUI$1(ManageChatroomUI manageChatroomUI) {
        this.hMS = manageChatroomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hMS.finish();
        return true;
    }
}
