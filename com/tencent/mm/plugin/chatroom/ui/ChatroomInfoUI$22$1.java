package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.22;

class ChatroomInfoUI$22$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ 22 hMj;

    ChatroomInfoUI$22$1(22 22, String str) {
        this.hMj = 22;
        this.dhF = str;
    }

    public final void run() {
        au.HU();
        c.Ga().m(this.dhF, System.currentTimeMillis());
    }

    public final String toString() {
        return super.toString() + "|getContactCallBack";
    }
}
