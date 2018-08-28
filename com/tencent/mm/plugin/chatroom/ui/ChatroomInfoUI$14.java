package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomInfoUI$14 implements OnClickListener {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ boolean hMa;

    ChatroomInfoUI$14(ChatroomInfoUI chatroomInfoUI, boolean z) {
        this.hLX = chatroomInfoUI;
        this.hMa = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ChatroomInfoUI.b(this.hLX) == null || ChatroomInfoUI.b(this.hLX).length() <= 0) {
            x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
            return;
        }
        if (this.hMa) {
            rn rnVar = new rn();
            rnVar.ccn.ccq = true;
            a.sFg.m(rnVar);
        }
        au.HU();
        if (c.FR().Yi(ChatroomInfoUI.b(this.hLX))) {
            ChatroomInfoUI.y(this.hLX);
            if (o.a.qyi != null) {
                o.a.qyi.HB(ChatroomInfoUI.b(this.hLX));
                return;
            }
            return;
        }
        x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(this.hLX) + "] is not exist");
    }
}
