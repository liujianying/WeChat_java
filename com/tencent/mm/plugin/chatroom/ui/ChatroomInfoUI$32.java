package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.am;
import com.tencent.mm.model.am.b.a;

class ChatroomInfoUI$32 implements Runnable {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ a hMn;

    ChatroomInfoUI$32(ChatroomInfoUI chatroomInfoUI, a aVar) {
        this.hLX = chatroomInfoUI;
        this.hMn = aVar;
    }

    public final void run() {
        am.a.dBr.a(ChatroomInfoUI.c(this.hLX).field_chatroomname, "", this.hMn);
    }

    public final String toString() {
        return super.toString() + "|getContactCallBack2";
    }
}
