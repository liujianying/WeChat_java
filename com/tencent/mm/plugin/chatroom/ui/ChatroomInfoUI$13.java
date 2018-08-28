package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class ChatroomInfoUI$13 implements c {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$13(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                ChatroomInfoUI.y(this.hLX);
                if (a.qyi != null) {
                    a.qyi.HB(ChatroomInfoUI.b(this.hLX));
                    return;
                }
                return;
            default:
                x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                return;
        }
    }
}
