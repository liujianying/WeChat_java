package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.chatroom.ui.RoomInfoDetailUI.2;

class RoomInfoDetailUI$2$2 implements OnClickListener {
    final /* synthetic */ 2 hNI;

    RoomInfoDetailUI$2$2(2 2) {
        this.hNI = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        RoomInfoDetailUI.a(this.hNI.hNH, true);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", RoomInfoDetailUI.a(this.hNI.hNH).field_username);
        intent.addFlags(67108864);
        d.e(this.hNI.hNH, ".ui.chatting.ChattingUI", intent);
    }
}
