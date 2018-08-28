package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class ChatroomInfoUI$38 implements a {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ String hMq;

    ChatroomInfoUI$38(ChatroomInfoUI chatroomInfoUI, String str) {
        this.hLX = chatroomInfoUI;
        this.hMq = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            ChatroomInfoUI.a(this.hLX, this.hMq, str, R.l.invitting_room_mem);
        }
    }
}
