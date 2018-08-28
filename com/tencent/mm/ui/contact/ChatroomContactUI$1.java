package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class ChatroomContactUI$1 implements d {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$1(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                ChatroomContactUI.aaK(ChatroomContactUI.a(this.uiv));
                return;
            default:
                return;
        }
    }
}
