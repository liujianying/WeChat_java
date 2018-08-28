package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;

class BizChatConversationUI$a$8 implements a {
    final /* synthetic */ long dAC;
    final /* synthetic */ BizChatConversationUI.a tEC;

    BizChatConversationUI$a$8(BizChatConversationUI.a aVar, long j) {
        this.tEC = aVar;
        this.dAC = j;
    }

    public final boolean Ip() {
        return BizChatConversationUI.a.o(this.tEC);
    }

    public final void Io() {
        int i = 0;
        if (BizChatConversationUI.a.p(this.tEC) != null) {
            z.Na().be(this.dAC);
            z.Nb().be(this.dAC);
            b Nb = z.Nb();
            String a = BizChatConversationUI.a.a(this.tEC);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select count(*) from BizChatConversation");
            stringBuilder.append(" where brandUserName = '").append(a).append("' ");
            Cursor b = Nb.diF.b(stringBuilder.toString(), null, 2);
            if (b != null) {
                if (b.moveToFirst()) {
                    i = b.getInt(0);
                }
                b.close();
            }
            if (i <= 0) {
                au.HU();
                c.FW().Yp(BizChatConversationUI.a.a(this.tEC));
            }
            BizChatConversationUI.a.p(this.tEC).dismiss();
        }
    }
}
