package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.g;

class SeeRoomMemberUI$9 implements OnCancelListener {
    final /* synthetic */ g hMc;
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$9(SeeRoomMemberUI seeRoomMemberUI, g gVar) {
        this.hOM = seeRoomMemberUI;
        this.hMc = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMc);
    }
}
