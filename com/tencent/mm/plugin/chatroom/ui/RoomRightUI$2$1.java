package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.j;
import com.tencent.mm.plugin.chatroom.ui.RoomRightUI.2;

class RoomRightUI$2$1 implements OnCancelListener {
    final /* synthetic */ j hNN;
    final /* synthetic */ 2 hNO;

    RoomRightUI$2$1(2 2, j jVar) {
        this.hNO = 2;
        this.hNN = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hNN);
    }
}
