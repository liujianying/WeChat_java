package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.g;

class ChatroomInfoUI$19 implements OnCancelListener {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ g hMc;

    ChatroomInfoUI$19(ChatroomInfoUI chatroomInfoUI, g gVar) {
        this.hLX = chatroomInfoUI;
        this.hMc = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMc);
    }
}
