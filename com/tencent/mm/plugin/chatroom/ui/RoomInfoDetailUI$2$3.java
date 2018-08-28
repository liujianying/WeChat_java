package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.RoomInfoDetailUI.2;

class RoomInfoDetailUI$2$3 implements OnClickListener {
    final /* synthetic */ 2 hNI;
    final /* synthetic */ ProgressDialog hsv;

    RoomInfoDetailUI$2$3(2 2, ProgressDialog progressDialog) {
        this.hNI = 2;
        this.hsv = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.hsv.show();
        RoomInfoDetailUI.a(this.hNI.hNH, false);
        RoomInfoDetailUI.a(this.hNI.hNH, this.hsv);
    }
}
