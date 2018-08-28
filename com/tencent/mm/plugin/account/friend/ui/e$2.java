package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class e$2 implements a {
    final /* synthetic */ e eMG;

    e$2(e eVar) {
        this.eMG = eVar;
    }

    public final void pB(String str) {
        ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        ao pA = apVar.pA(str);
        if (pA == null) {
            x.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[]{str});
            return;
        }
        pA.eLx = 2;
        apVar.a(pA.eLw, pA);
        this.eMG.notifyDataSetChanged();
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            pA = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).pA(str);
            if (pA != null) {
                pA.Yc();
                x.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + pA.eLw);
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(pA.eLw, pA);
            }
        } else if (!((Yg.field_conRemark != null && !Yg.field_conRemark.equals("")) || pA == null || pA.XZ() == null || pA.XZ().equals(""))) {
            s.b(Yg, pA.XZ());
        }
        br.IE().c(26, new Object[0]);
    }

    public final void Q(String str, boolean z) {
        if (z) {
            ao pA = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).pA(str);
            if (pA != null) {
                pA.Yc();
                x.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + pA.eLw);
                ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(pA.eLw, pA);
            } else {
                x.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[]{str});
            }
        }
        this.eMG.notifyDataSetChanged();
    }
}
