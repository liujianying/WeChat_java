package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e$b;

class j$2 implements b<e$b> {
    final /* synthetic */ j vnb;
    final /* synthetic */ h vnc;

    j$2(j jVar, h hVar) {
        this.vnb = jVar;
        this.vnc = hVar;
    }

    public final /* synthetic */ void cG(Object obj) {
        e$b e_b = (e$b) obj;
        j.dC(d.cFJ().vly, 0);
        c.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", new Object[]{Boolean.valueOf(e_b.vme)});
        if (e_b.vme) {
            this.vnb.b(new com.tencent.d.b.a.c(this.vnc));
            return;
        }
        a.cFB();
        this.vnb.b(new com.tencent.d.b.a.c(9, "upload app secure key failed"));
    }
}
