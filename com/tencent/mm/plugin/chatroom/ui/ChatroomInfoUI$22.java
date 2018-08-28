package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;

class ChatroomInfoUI$22 implements a {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$22(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void x(String str, boolean z) {
        if (z && ChatroomInfoUI.b(this.hLX).equals(str)) {
            au.Em().H(new 1(this, str));
        }
    }
}
