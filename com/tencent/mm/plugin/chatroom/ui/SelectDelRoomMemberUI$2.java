package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectDelRoomMemberUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SelectDelRoomMemberUI hPa;

    SelectDelRoomMemberUI$2(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.hPa = selectDelRoomMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hPa.finish();
        return false;
    }
}
