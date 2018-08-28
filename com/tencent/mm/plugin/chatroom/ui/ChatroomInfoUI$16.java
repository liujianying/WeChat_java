package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class ChatroomInfoUI$16 implements OnClickListener {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$16(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.b(this.hLX)});
        ChatroomInfoUI.a(this.hLX, true);
        if (ChatroomInfoUI.x(this.hLX)) {
            this.hLX.finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", ChatroomInfoUI.o(this.hLX).field_username);
        intent.addFlags(67108864);
        d.e(this.hLX, ".ui.chatting.ChattingUI", intent);
    }
}
