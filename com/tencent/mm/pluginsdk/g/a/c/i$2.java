package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class i$2 implements Runnable {
    final /* synthetic */ m fht;
    final /* synthetic */ String qBR;
    final /* synthetic */ List qDb;
    final /* synthetic */ i qDc;

    i$2(i iVar, List list, m mVar, String str) {
        this.qDc = iVar;
        this.qDb = list;
        this.fht = mVar;
        this.qBR = str;
    }

    public final void run() {
        for (d dVar : this.qDb) {
            if (bi.oV(dVar.aca()).equals(this.fht.groupId)) {
                dVar.a(this.qBR, this.fht);
            }
        }
    }
}
