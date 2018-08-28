package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class ChatroomInfoUI$37 implements Runnable {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ int hMp;

    ChatroomInfoUI$37(ChatroomInfoUI chatroomInfoUI, int i) {
        this.hLX = chatroomInfoUI;
        this.hMp = i;
    }

    public final void run() {
        View a = ((a) ChatroomInfoUI.f(this.hLX)).a(this.hMp, this.hLX.kww);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.hLX.mController.tml, a);
        }
    }
}
