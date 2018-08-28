package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class SelectDelRoomMemberUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectDelRoomMemberUI hPa;

    SelectDelRoomMemberUI$1(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.hPa = selectDelRoomMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.hPa, this.hPa.getString(R.l.room_del_this_members_tip), "", new 1(this), new 2(this));
        return false;
    }
}
