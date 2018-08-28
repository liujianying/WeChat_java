package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.bd.a;

class ChatroomInfoUI$18 implements a {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$18(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final boolean Ip() {
        return ChatroomInfoUI.z(this.hLX);
    }

    public final void Io() {
        if (ChatroomInfoUI.A(this.hLX) != null) {
            ChatroomInfoUI.A(this.hLX).dismiss();
        }
    }
}
