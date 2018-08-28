package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

class RoomCardUI$3 implements OnLongClickListener {
    final /* synthetic */ RoomCardUI hNw;

    RoomCardUI$3(RoomCardUI roomCardUI) {
        this.hNw = roomCardUI;
    }

    public final boolean onLongClick(View view) {
        RoomCardUI.a(this.hNw, RoomCardUI.b(this.hNw));
        return true;
    }
}
