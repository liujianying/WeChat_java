package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.e.1;
import com.tencent.mm.plugin.account.friend.ui.g.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements a {
    final /* synthetic */ 1 eMH;

    e$1$1(1 1) {
        this.eMH = 1;
    }

    public final void c(boolean z, String str) {
        ao bK = ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).bK((long) o.cx(str));
        if (bK != null) {
            bK.dHO = 2;
            x.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[]{bK.toString()});
            ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(bK.eLw, bK);
            this.eMH.eMG.WT();
            return;
        }
        x.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[]{bK});
    }
}
