package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RoomCardUI$8 implements OnClickListener {
    final /* synthetic */ RoomCardUI hNw;

    RoomCardUI$8(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.hNw.setResult(0);
        this.hNw.finish();
    }
}
