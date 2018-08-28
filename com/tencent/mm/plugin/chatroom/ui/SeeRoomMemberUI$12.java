package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.d;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

class SeeRoomMemberUI$12 implements OnClickListener {
    final /* synthetic */ d hMd;
    final /* synthetic */ List hMe;
    final /* synthetic */ List hMf;
    final /* synthetic */ List hMg;
    final /* synthetic */ SeeRoomMemberUI hOM;

    SeeRoomMemberUI$12(SeeRoomMemberUI seeRoomMemberUI, d dVar, List list, List list2, List list3) {
        this.hOM = seeRoomMemberUI;
        this.hMd = dVar;
        this.hMe = list;
        this.hMf = list2;
        this.hMg = list3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SeeRoomMemberUI.a(this.hOM, this.hMd.chatroomName, this.hMe);
        List arrayList = new ArrayList();
        arrayList.addAll(this.hMf);
        arrayList.addAll(this.hMg);
        k kVar = new k(SeeRoomMemberUI.k(this.hOM), arrayList);
        au.DF().a(kVar, 0);
        SeeRoomMemberUI seeRoomMemberUI = this.hOM;
        SeeRoomMemberUI seeRoomMemberUI2 = this.hOM;
        this.hOM.getString(R.l.app_tip);
        SeeRoomMemberUI.a(seeRoomMemberUI, h.a(seeRoomMemberUI2, this.hOM.getString(R.l.room_invite_member), true, new 1(this, kVar)));
    }
}
