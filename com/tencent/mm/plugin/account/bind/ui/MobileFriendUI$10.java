package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.x;

class MobileFriendUI$10 implements b {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$10(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void bK(boolean z) {
        x.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            System.currentTimeMillis();
            g.DF().a(new al(l.XJ(), l.XI()), 0);
        } else if (MobileFriendUI.b(this.eIS) != null) {
            MobileFriendUI.b(this.eIS).dismiss();
            MobileFriendUI.c(this.eIS);
        }
    }
}
