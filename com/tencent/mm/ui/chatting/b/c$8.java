package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class c$8 implements Runnable {
    final /* synthetic */ c tOm;

    c$8(c cVar) {
        this.tOm = cVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.tOm.qIZ || this.tOm.tDV == null || this.tOm.bAG.oLT == null) {
            x.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[]{this.tOm.tDV, this.tOm.bAG.oLT});
        } else {
            c.e(this.tOm);
            z.Nl();
            c cVar = this.tOm.tDV;
            if (a.gI(g.Eg().dpx)) {
                com.tencent.mm.modelsimple.z.a(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                x.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[]{r3});
            }
            if (this.tOm.tOe) {
                if (this.tOm.tDV.No()) {
                    z.Ng();
                    h.am(this.tOm.tDV.field_bizChatServId, this.tOm.bAG.oLT.field_username);
                } else {
                    e.f(this.tOm.tDV);
                }
            }
            c.f(this.tOm);
        }
        x.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
