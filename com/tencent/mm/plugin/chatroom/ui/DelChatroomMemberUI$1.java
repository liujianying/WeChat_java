package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class DelChatroomMemberUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ DelChatroomMemberUI hMA;

    DelChatroomMemberUI$1(DelChatroomMemberUI delChatroomMemberUI) {
        this.hMA = delChatroomMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hMA.finish();
        return true;
    }
}
