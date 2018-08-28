package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.10;
import com.tencent.mm.plugin.report.service.h;

class ChatroomInfoUI$10$2 implements OnClickListener {
    final /* synthetic */ 10 hLZ;
    final /* synthetic */ ProgressDialog hsv;

    ChatroomInfoUI$10$2(10 10, ProgressDialog progressDialog) {
        this.hLZ = 10;
        this.hsv = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(14553, new Object[]{Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(this.hLZ.hLX)});
        this.hsv.show();
        ChatroomInfoUI.a(this.hLZ.hLX, false);
        ChatroomInfoUI.a(this.hLZ.hLX, this.hsv);
    }
}
