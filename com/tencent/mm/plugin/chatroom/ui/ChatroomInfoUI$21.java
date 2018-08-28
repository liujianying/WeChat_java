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

class ChatroomInfoUI$21 implements OnClickListener {
    final /* synthetic */ ChatroomInfoUI hLX;
    final /* synthetic */ d hMd;
    final /* synthetic */ List hMe;
    final /* synthetic */ List hMf;
    final /* synthetic */ List hMg;

    ChatroomInfoUI$21(ChatroomInfoUI chatroomInfoUI, d dVar, List list, List list2, List list3) {
        this.hLX = chatroomInfoUI;
        this.hMd = dVar;
        this.hMe = list;
        this.hMf = list2;
        this.hMg = list3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ChatroomInfoUI.a(this.hLX, this.hMd.chatroomName, this.hMe);
        List arrayList = new ArrayList();
        arrayList.addAll(this.hMf);
        arrayList.addAll(this.hMg);
        k kVar = new k(ChatroomInfoUI.b(this.hLX), arrayList);
        au.DF().a(kVar, 0);
        ChatroomInfoUI chatroomInfoUI = this.hLX;
        ChatroomInfoUI chatroomInfoUI2 = this.hLX;
        this.hLX.getString(R.l.app_tip);
        ChatroomInfoUI.b(chatroomInfoUI, h.a(chatroomInfoUI2, this.hLX.getString(R.l.room_invite_member), true, new 1(this, kVar)));
    }
}
