package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.r;

public abstract class d extends r<ao> implements c {
    public d(Context context, ao aoVar) {
        super(context, aoVar);
    }

    public void a(a aVar) {
    }

    public void pi(String str) {
    }

    public static void pC(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        ao pA = ((ap) ((a) g.n(a.class)).getQQListStg()).pA(str);
        if (pA != null) {
            pA.eLx = 2;
            ((ap) ((a) g.n(a.class)).getQQListStg()).a(pA.eLw, pA);
        }
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            x.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        com.tencent.mm.l.a Yg2;
        if (bi.oW(Yg.field_username)) {
            Yg.setUsername(str);
        }
        if (((int) Yg.dhP) == 0) {
            ((i) g.l(i.class)).FR().U(Yg);
            if (!bi.oW(Yg.field_username)) {
                Yg2 = ((i) g.l(i.class)).FR().Yg(Yg.field_username);
            } else {
                return;
            }
        }
        Yg2 = Yg;
        if (((int) Yg2.dhP) <= 0) {
            x.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        s.p(Yg2);
        br.IE().c(26, new Object[0]);
    }
}
