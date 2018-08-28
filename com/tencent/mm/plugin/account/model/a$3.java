package com.tencent.mm.plugin.account.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class a$3 implements b {
    final /* synthetic */ a eNP;

    a$3(a aVar) {
        this.eNP = aVar;
    }

    public final void bK(boolean z) {
        x.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            return;
        }
        if (l.XJ().size() > 0) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
            g.DF().a(133, this.eNP);
            System.currentTimeMillis();
            g.DF().a(new al(l.XJ(), l.XI()), 0);
            return;
        }
        x.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        String[] strArr = (String[]) this.eNP.eNM.toArray(new String[0]);
        this.eNP.eNM.clear();
        List arrayList = new ArrayList();
        for (String pp : strArr) {
            a pp2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(pp);
            if (pp2 == null || bi.oW(pp2.Xp())) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[]{pp});
            } else {
                arrayList.add(pp2.Xp());
                x.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[]{pp2.Xp(), pp});
            }
        }
        g.DF().a(32, this.eNP);
        if (arrayList.size() == 0) {
            x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
            g.DF().a(new ab(), 0);
            return;
        }
        x.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[]{Integer.valueOf(arrayList.size())});
        g.DF().a(new ab(arrayList, null), 0);
    }
}
