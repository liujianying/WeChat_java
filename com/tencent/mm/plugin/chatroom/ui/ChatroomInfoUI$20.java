package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.d;

class ChatroomInfoUI$20 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ d hMd;

    ChatroomInfoUI$20(ChatroomInfoUI chatroomInfoUI, d dVar) {
        this.hLX = chatroomInfoUI;
        this.hMd = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMd);
    }
}
