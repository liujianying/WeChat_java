package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ac.c$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.g;

class BizChatConversationUI$a$14 implements c$a {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$14(a aVar) {
        this.tEC = aVar;
    }

    public final void a(c$a.a aVar) {
        String d = a.d(this.tEC);
        if (aVar != null && !bi.oW(aVar.dKF) && aVar.dKF.equals(d)) {
            int l = a.l(this.tEC);
            a.c(this.tEC, g.bu(this.tEC.getContext(), d));
            if (a.l(this.tEC) != l) {
                a.r(this.tEC);
            }
        }
    }
}
