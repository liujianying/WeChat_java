package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.2;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;

class d$1 implements Runnable {
    final /* synthetic */ d gZJ;

    d$1(d dVar) {
        this.gZJ = dVar;
    }

    public final void run() {
        d dVar = this.gZJ;
        dVar.gZI = 0;
        dVar.gZD = new 2(dVar);
        b.a(5, dVar.gZD);
        String str = (String) com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().DT().get(2, null);
        for (String str2 : dVar.gZA) {
            ai Yq = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atm().FW().Yq(str2);
            x.i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", new Object[]{str2, Integer.valueOf(Yq != null ? Yq.field_unReadCount : 0)});
            if (!dVar.o(str2, str, Yq != null ? Yq.field_unReadCount : 0)) {
                x.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                return;
            }
        }
        dVar.gZE = true;
        x.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
        dVar.asU();
    }
}
