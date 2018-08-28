package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.bind.ui.c.1;
import com.tencent.mm.ui.MMActivity.a;

class c$1$3 implements a {
    final /* synthetic */ 1 eIw;
    final /* synthetic */ com.tencent.mm.plugin.account.friend.a.a eIx;

    c$1$3(1 1, com.tencent.mm.plugin.account.friend.a.a aVar) {
        this.eIw = 1;
        this.eIx = aVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            ((MobileFriendUI) c.d(this.eIw.eIv)).b(this.eIx);
        }
    }
}
