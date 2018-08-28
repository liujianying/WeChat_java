package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.a$a;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.vending.c.a;

class ChatroomInfoUI$34 implements a<Void, a$a<abx>> {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$34(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a a_a = (a$a) obj;
        if (a_a == null) {
            return uQG;
        }
        int i = a_a.errType;
        int i2 = a_a.errCode;
        if (i == 0 && i2 == 0) {
            if (ChatroomInfoUI.c(this.hLX) != null) {
                ChatroomInfoUI.a(this.hLX, ChatroomInfoUI.c(this.hLX).Nn().size());
            }
            if ((!ChatroomInfoUI.d(this.hLX) && ChatroomInfoUI.e(this.hLX) >= j.qIV) || (ChatroomInfoUI.d(this.hLX) && ChatroomInfoUI.e(this.hLX) >= j.qIV - 1)) {
                ChatroomInfoUI.f(this.hLX).bw("see_room_member", false);
                ChatroomInfoUI.g(this.hLX).setTitle(this.hLX.getString(R.l.see_member_selector_btn));
            }
        }
        ChatroomInfoUI.h(this.hLX);
        ChatroomInfoUI.i(this.hLX);
        ChatroomInfoUI.j(this.hLX);
        return uQG;
    }
}
