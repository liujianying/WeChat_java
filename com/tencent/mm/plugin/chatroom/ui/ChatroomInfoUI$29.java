package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomInfoUI$29 implements Runnable {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$29(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void run() {
        ChatroomInfoUI chatroomInfoUI = this.hLX;
        au.HU();
        ChatroomInfoUI.a(chatroomInfoUI, c.Ga().ih(ChatroomInfoUI.b(this.hLX)));
        if (ChatroomInfoUI.c(this.hLX) == null) {
            x.e("MicroMsg.ChatroomInfoUI", "member is null");
        } else if (bi.oW(ChatroomInfoUI.c(this.hLX).field_roomowner)) {
            x.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
        } else {
            ChatroomInfoUI.C(this.hLX).sendEmptyMessage(0);
            ChatroomInfoUI.c(this.hLX, ChatroomInfoUI.c(this.hLX).field_roomowner.equals(q.GF()));
            ChatroomInfoUI.m(this.hLX).TL(ChatroomInfoUI.c(this.hLX).field_roomowner);
        }
    }

    public final String toString() {
        return super.toString() + "|onNotifyChange";
    }
}
