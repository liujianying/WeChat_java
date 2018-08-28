package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

class ChatroomInfoUI$26 extends b {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$26(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        if (bVar instanceof ka) {
            ka kaVar = (ka) bVar;
            x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (ChatroomInfoUI.A(this.hLX) != null) {
                ChatroomInfoUI.A(this.hLX).dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (i == 0 && i2 == 0 && ChatroomInfoUI.m(this.hLX) != null) {
                    ArrayList aD = ChatroomInfoUI.aD(kaVar.bUp.bUb);
                    ContactListExpandPreference m = ChatroomInfoUI.m(this.hLX);
                    if (m.qJA != null) {
                        j jVar = m.qJA.qIM;
                        jVar.Z(aD);
                        jVar.notifyChanged();
                    }
                    if (ChatroomInfoUI.f(this.hLX) != null) {
                        ChatroomInfoUI.f(this.hLX).notifyDataSetChanged();
                    }
                    this.hLX.setMMTitle(this.hLX.getResources().getQuantityString(R.j.room_lbsroom_member_title, aD.size(), new Object[]{Integer.valueOf(aD.size())}));
                }
                ChatroomInfoUI.j(this.hLX);
            } else if (i2 == -21) {
                h.a(this.hLX, this.hLX.getString(R.l.room_lbsroom_auto_quit), this.hLX.getString(R.l.app_tip), new 1(this));
            } else {
                h.b(this.hLX, this.hLX.getString(R.l.room_lbsroom_member_loading_failed), this.hLX.getString(R.l.app_tip), true);
            }
        }
    }
}
