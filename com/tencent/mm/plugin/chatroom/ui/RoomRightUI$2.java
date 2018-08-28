package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.j;
import com.tencent.mm.ui.base.h;

class RoomRightUI$2 implements OnClickListener {
    final /* synthetic */ RoomRightUI hNL;
    final /* synthetic */ String hNM;

    RoomRightUI$2(RoomRightUI roomRightUI, String str) {
        this.hNL = roomRightUI;
        this.hNM = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j jVar = new j(this.hNM);
        RoomRightUI roomRightUI = this.hNL;
        RoomRightUI roomRightUI2 = this.hNL;
        this.hNL.getString(R.l.app_tip);
        RoomRightUI.a(roomRightUI, h.a(roomRightUI2, "", true, new 1(this, jVar)));
        au.DF().a(jVar, 0);
    }
}
