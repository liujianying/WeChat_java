package com.tencent.mm.platformtools;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements b {
    b$1() {
    }

    public final void bK(boolean z) {
        x.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            System.currentTimeMillis();
            g.DF().a(new al(l.XJ(), l.XI()), 0);
        }
    }
}
