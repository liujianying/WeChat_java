package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class ChatroomContactUI$8 implements c {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$8(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final int cl(View view) {
        return ChatroomContactUI.b(this.uiv).getPositionForView(view);
    }
}
