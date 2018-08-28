package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.s;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends a {
    final /* synthetic */ e gZX;

    e$1(e eVar) {
        this.gZX = eVar;
    }

    public final void run() {
        s sVar = new s();
        if (this.hbk) {
            sVar.hbZ = this.dbSize;
            sVar.hcx = this.hbm - this.dbSize;
            sVar.hcw = this.hbl;
            e eVar = this.gZX;
            e.a(6, 0, sVar);
            b.a(3, new 2(eVar));
            x.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).ass();
            return;
        }
        if (this.dbSize > this.hbm && this.hbm > 0) {
            sVar.hbZ = this.dbSize;
            sVar.hcx = this.hbm - this.dbSize;
        }
        e.a(6, 14, sVar);
        x.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
    }
}
