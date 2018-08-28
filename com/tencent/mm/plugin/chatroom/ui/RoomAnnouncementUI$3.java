package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RoomAnnouncementUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ RoomAnnouncementUI hNd;

    RoomAnnouncementUI$3(RoomAnnouncementUI roomAnnouncementUI) {
        this.hNd = roomAnnouncementUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hNd.setResult(0);
        this.hNd.finish();
        return true;
    }
}
