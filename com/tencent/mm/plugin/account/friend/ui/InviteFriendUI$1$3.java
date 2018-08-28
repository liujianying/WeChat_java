package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;

class InviteFriendUI$1$3 implements c {
    final /* synthetic */ HashMap eMw;
    final /* synthetic */ 1 eMy;

    InviteFriendUI$1$3(1 1, HashMap hashMap) {
        this.eMy = 1;
        this.eMw = hashMap;
    }

    public final void a(l lVar) {
        for (CharSequence add : this.eMw.keySet()) {
            lVar.add(add);
        }
    }
}
