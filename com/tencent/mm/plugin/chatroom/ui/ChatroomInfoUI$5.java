package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ChatroomInfoUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$5(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hLX.finish();
        return true;
    }
}
