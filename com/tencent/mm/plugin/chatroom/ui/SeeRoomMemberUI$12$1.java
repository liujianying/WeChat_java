package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.12;

class SeeRoomMemberUI$12$1 implements OnCancelListener {
    final /* synthetic */ k hMh;
    final /* synthetic */ 12 hOO;

    SeeRoomMemberUI$12$1(12 12, k kVar) {
        this.hOO = 12;
        this.hMh = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMh);
    }
}
