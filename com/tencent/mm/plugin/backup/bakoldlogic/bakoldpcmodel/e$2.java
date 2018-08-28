package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.3;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements e {
    final /* synthetic */ e gZX;

    e$2(e eVar) {
        this.gZX = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        b bVar = (b) lVar;
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 3) {
                ac acVar = (ac) bVar.asj();
                if (acVar.hbr == 2) {
                    final r rVar = acVar.hcY;
                    Runnable anonymousClass1 = new Runnable() {
                        public final void run() {
                            e$2.this.gZX.a(rVar);
                        }
                    };
                    2 2 = new 2(this);
                    e eVar = this.gZX;
                    x.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", new Object[]{rVar.ID});
                    au.DF().a(596, new 3(eVar, anonymousClass1, 2));
                    if (eVar.gZP != null) {
                        eVar.gZP.cancel();
                    }
                    eVar.gZP = new com.tencent.mm.plugin.backup.bakoldlogic.c.e(r0);
                    au.DF().a(eVar.gZP, 0);
                }
            }
            b.b(3, this);
            return;
        }
        x.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
