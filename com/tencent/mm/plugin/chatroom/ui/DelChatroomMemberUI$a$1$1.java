package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.DelChatroomMemberUI.a.1;
import com.tencent.mm.storage.ab;

class DelChatroomMemberUI$a$1$1 implements OnClickListener {
    final /* synthetic */ ab hMD;
    final /* synthetic */ 1 hME;

    DelChatroomMemberUI$a$1$1(1 1, ab abVar) {
        this.hME = 1;
        this.hMD = abVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DelChatroomMemberUI.a(this.hME.hMC.hMA, this.hMD.field_username);
    }
}
