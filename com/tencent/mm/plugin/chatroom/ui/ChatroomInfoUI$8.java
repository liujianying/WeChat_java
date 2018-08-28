package com.tencent.mm.plugin.chatroom.ui;

import android.widget.Toast;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatroomInfoUI$8 extends c<ll> {
    final /* synthetic */ ChatroomInfoUI hLX;

    ChatroomInfoUI$8(ChatroomInfoUI chatroomInfoUI) {
        this.hLX = chatroomInfoUI;
        this.sFo = ll.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ll llVar = (ll) bVar;
        CharSequence charSequence = llVar.bVN.bVP;
        int i = llVar.bVN.ret;
        if (i == 0 || charSequence == null) {
            if (i == 0 && ChatroomInfoUI.t(this.hLX)) {
                if (this.hLX.hLN == 27) {
                    a.sFg.m(new sh());
                    ChatroomInfoUI.o(this.hLX).dx(this.hLX.eOz);
                    au.HU();
                    com.tencent.mm.model.c.FR().S(ChatroomInfoUI.o(this.hLX));
                    ChatroomInfoUI.i(this.hLX);
                } else if (this.hLX.hLN == 48 && ChatroomInfoUI.c(this.hLX) != null) {
                    ChatroomInfoUI.c(this.hLX).field_chatroomname = ChatroomInfoUI.b(this.hLX);
                    ChatroomInfoUI.c(this.hLX).field_selfDisplayName = ChatroomInfoUI.u(this.hLX);
                    au.HU();
                    com.tencent.mm.model.c.Ga().c(ChatroomInfoUI.c(this.hLX), new String[0]);
                    ChatroomInfoUI.v(this.hLX);
                }
            }
        } else if (ChatroomInfoUI.r(this.hLX) != null && this.hLX.hLN == 27) {
            au.HU();
            com.tencent.mm.model.c.FQ().c(ChatroomInfoUI.r(this.hLX));
        } else if (ChatroomInfoUI.s(this.hLX) != null && this.hLX.hLN == 48) {
            au.HU();
            com.tencent.mm.model.c.FQ().c(ChatroomInfoUI.s(this.hLX));
            Toast.makeText(this.hLX.mController.tml, charSequence, 1).show();
        }
        if (ChatroomInfoUI.w(this.hLX) != null) {
            ChatroomInfoUI.w(this.hLX).dismiss();
        }
        return false;
    }
}
