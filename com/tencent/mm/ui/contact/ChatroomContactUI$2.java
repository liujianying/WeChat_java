package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ChatroomContactUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$2(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uiv.finish();
        return false;
    }
}
