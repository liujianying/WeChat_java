package com.tencent.mm.modelfriend;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.x;

class AddrBookObserver$AddrBookService$1 implements b {
    final /* synthetic */ AddrBookService dRA;

    AddrBookObserver$AddrBookService$1(AddrBookService addrBookService) {
        this.dRA = addrBookService;
    }

    public final void bK(boolean z) {
        if (z) {
            System.currentTimeMillis();
            g.DF().a(new al(l.XJ(), l.XI()), 0);
            this.dRA.stopSelf();
            AddrBookService.dRw = false;
            return;
        }
        x.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
        this.dRA.stopSelf();
        AddrBookService.dRw = false;
    }
}
