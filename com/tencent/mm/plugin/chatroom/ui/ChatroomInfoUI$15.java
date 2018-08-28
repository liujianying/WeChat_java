package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ChatroomInfoUI$15 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$15(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ChatroomInfoUI.a(this.hLX, true);
    }
}
