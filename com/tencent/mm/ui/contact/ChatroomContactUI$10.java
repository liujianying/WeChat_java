package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class ChatroomContactUI$10 implements f {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$10(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
            return;
        }
        ChatroomContactUI.aaK(obj.toString());
        ChatroomContactUI.c(this.uiv);
    }
}
