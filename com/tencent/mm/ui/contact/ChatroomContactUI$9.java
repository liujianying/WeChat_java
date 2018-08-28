package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.g;

class ChatroomContactUI$9 implements g {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$9(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void t(View view, int i) {
        ChatroomContactUI.b(this.uiv).performItemClick(view, i, 0);
    }
}
