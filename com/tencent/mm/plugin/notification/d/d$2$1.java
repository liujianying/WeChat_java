package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.oz;
import com.tencent.mm.plugin.notification.d.d.2;
import com.tencent.mm.storage.bd;

class d$2$1 implements Runnable {
    final /* synthetic */ oz lHP;
    final /* synthetic */ 2 lHQ;

    d$2$1(2 2, oz ozVar) {
        this.lHQ = 2;
        this.lHP = ozVar;
    }

    public final void run() {
        bd bdVar = this.lHP.bZU.bGS;
        if (d.IT(bdVar.field_talker)) {
            this.lHQ.lHM.bK(bdVar);
        }
    }
}
