package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI.21;

class ChatroomInfoUI$21$1 implements OnCancelListener {
    final /* synthetic */ k hMh;
    final /* synthetic */ 21 hMi;

    ChatroomInfoUI$21$1(21 21, k kVar) {
        this.hMi = 21;
        this.hMh = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMh);
    }
}
