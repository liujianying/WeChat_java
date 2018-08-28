package com.tencent.mm.plugin.j;

import com.tencent.mm.plugin.j.b.10;
import com.tencent.mm.plugin.j.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Iterator;

class b$10$1 implements Runnable {
    final /* synthetic */ c htd;
    final /* synthetic */ 10 hte;

    b$10$1(10 10, c cVar) {
        this.hte = 10;
        this.htd = cVar;
    }

    public final void run() {
        x.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[]{this.htd.lcx, Integer.valueOf(this.htd.lcy.size())});
        if (!"delete".equals(this.htd.lcx)) {
            int i = "delete".equals(this.htd.lcx) ? 2 : 1;
            Iterator it = this.htd.lcy.iterator();
            while (it.hasNext()) {
                bd bdVar = (bd) it.next();
                if (bdVar != null) {
                    boolean contains;
                    b bVar = this.hte.hsX;
                    long j = bdVar.field_msgId;
                    if (bVar.hsJ) {
                        contains = bVar.hsI.contains(Long.valueOf(j));
                    } else {
                        contains = false;
                    }
                    if (contains) {
                        x.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[]{Long.valueOf(bdVar.field_msgId)});
                    } else {
                        b.d(this.hte.hsX).H(new a(bdVar, i));
                    }
                }
            }
        }
    }
}
