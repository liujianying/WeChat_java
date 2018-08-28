package com.tencent.mm.plugin.account.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.x;

class ContactsSyncService$1 implements b {
    final /* synthetic */ ContactsSyncService eNT;

    ContactsSyncService$1(ContactsSyncService contactsSyncService) {
        this.eNT = contactsSyncService;
    }

    public final void bK(boolean z) {
        x.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            g.DF().a(133, this.eNT);
            System.currentTimeMillis();
            g.DF().a(new al(l.XJ(), l.XI()), 0);
            return;
        }
        ContactsSyncService.a(this.eNT);
    }
}
