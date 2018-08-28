package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements e {
    final /* synthetic */ f haj;

    f$2(f fVar) {
        this.haj = fVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        ac acVar = (ac) ((b) lVar).asj();
        if (acVar.hbr == 2) {
            r rVar = acVar.hcY;
            this.haj.had.addAll(rVar.hcv);
            this.haj.hac.addAll(rVar.hcu);
            x.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", new Object[]{Integer.valueOf(this.haj.had.size()), Integer.valueOf(this.haj.hac.size()), Integer.valueOf(rVar.hch), Integer.valueOf(rVar.hcg)});
            if (this.haj.had.size() < rVar.hch || this.haj.hac.size() < rVar.hcg) {
                x.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).ass();
                return;
            }
            this.haj.hag = rVar.hcc;
            x.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", new Object[]{Long.valueOf(this.haj.hag)});
            b.b(3, this);
            com.tencent.mm.sdk.f.e.post(new 1(this), "RecoverPCServer_recover_getIDList");
        }
    }
}
