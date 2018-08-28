package com.tencent.mm.ui.conversation;

import com.tencent.mm.ac.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.g;

class EnterpriseConversationUI$a$10 implements a {
    final /* synthetic */ EnterpriseConversationUI.a uqA;

    EnterpriseConversationUI$a$10(EnterpriseConversationUI.a aVar) {
        this.uqA = aVar;
    }

    public final void a(a.a aVar) {
        if (aVar != null && !bi.oW(aVar.dKF) && aVar.dKF.equals(EnterpriseConversationUI.a.c(this.uqA))) {
            int e = EnterpriseConversationUI.a.e(this.uqA);
            EnterpriseConversationUI.a.b(this.uqA, g.bu(this.uqA.getContext(), EnterpriseConversationUI.a.c(this.uqA)));
            if (EnterpriseConversationUI.a.e(this.uqA) != e) {
                EnterpriseConversationUI.a.q(this.uqA);
            }
        }
    }
}
