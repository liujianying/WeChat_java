package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.bind.ui.d.1;
import com.tencent.mm.ui.MMActivity.a;

class d$1$3 implements a {
    final /* synthetic */ 1 eIF;
    final /* synthetic */ com.tencent.mm.plugin.account.friend.a.a eIx;

    d$1$3(1 1, com.tencent.mm.plugin.account.friend.a.a aVar) {
        this.eIF = 1;
        this.eIx = aVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            ((MobileFriendUI) d.d(this.eIF.eIE)).b(this.eIx);
        }
    }
}
