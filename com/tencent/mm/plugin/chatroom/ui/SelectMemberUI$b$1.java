package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.a;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b.3;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.Collections;
import java.util.List;

class SelectMemberUI$b$1 implements Runnable {
    final /* synthetic */ b hPA;

    SelectMemberUI$b$1(b bVar) {
        this.hPA = bVar;
    }

    public final void run() {
        b.a(this.hPA, true);
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.hPA;
        List Nn = b.a(this.hPA).Nn();
        if (Nn != null) {
            bVar.bTR.clear();
            for (int i = 0; i < Nn.size(); i++) {
                ab Yg = c.FR().Yg((String) Nn.get(i));
                boolean equals = Yg.field_username.equals(bVar.hOQ);
                if (!equals || SelectMemberUI.h(bVar.hPv)) {
                    if (equals && SelectMemberUI.h(bVar.hPv)) {
                        bVar.bTR.add(0, new a(bVar.hPv, Yg));
                    } else {
                        bVar.bTR.add(new a(bVar.hPv, Yg));
                    }
                }
            }
            Collections.sort(bVar.bTR, new 3(bVar));
            bVar.hOR = bVar.bTR;
        }
        b.b(this.hPA);
        x.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ah.A(new Runnable() {
            public final void run() {
                b.a(SelectMemberUI$b$1.this.hPA, false);
                SelectMemberUI.f(SelectMemberUI$b$1.this.hPA.hPv).setVisibility(8);
                SelectMemberUI$b$1.this.hPA.notifyDataSetChanged();
            }
        });
    }
}
