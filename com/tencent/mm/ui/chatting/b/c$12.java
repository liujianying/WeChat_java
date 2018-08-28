package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.e$a$b;
import com.tencent.mm.ac.e.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class c$12 implements a {
    final /* synthetic */ c tOm;

    c$12(c cVar) {
        this.tOm = cVar;
    }

    public final void a(e$a$b e_a_b) {
        if (e_a_b != null && e_a_b.dMb == a.a.dLZ && e_a_b.dKF != null && e_a_b.dKF.equals(this.tOm.bAG.getTalkerUserName())) {
            au.HU();
            ab Yg = c.FR().Yg(e_a_b.dKF);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                x.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[]{e_a_b.dKF});
                return;
            }
            ah.A(new 1(this, e_a_b, Yg));
        }
    }
}
