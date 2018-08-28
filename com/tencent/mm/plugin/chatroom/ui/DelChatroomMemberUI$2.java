package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.g;

class DelChatroomMemberUI$2 implements OnCancelListener {
    final /* synthetic */ DelChatroomMemberUI hMA;
    final /* synthetic */ g hMc;

    DelChatroomMemberUI$2(DelChatroomMemberUI delChatroomMemberUI, g gVar) {
        this.hMA = delChatroomMemberUI;
        this.hMc = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMc);
    }
}
