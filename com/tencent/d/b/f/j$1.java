package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.h;
import com.tencent.d.b.d.a;
import com.tencent.d.b.e.e;
import com.tencent.d.b.f.j.2;

class j$1 implements a {
    final /* synthetic */ j vnb;

    j$1(j jVar) {
        this.vnb = jVar;
    }

    public final void onError(int i, String str) {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(i), str});
        j.dC(d.cFJ().vly, 0);
        this.vnb.b(new com.tencent.d.b.a.c(i, str));
    }

    public final void onSuccess() {
        c.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
        if (this.vnb.vmZ != null) {
            j.dC(d.cFJ().vly, 2);
        } else {
            j.dC(d.cFJ().vly, 0);
        }
        j jVar = this.vnb;
        h cFE = com.tencent.d.a.a.cFE();
        if (cFE == null) {
            c.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
            com.tencent.d.a.a.cFB();
            jVar.b(new com.tencent.d.b.a.c(3, "ask model is null even after generation."));
        } else if (jVar.vmZ != null) {
            jVar.vmZ.bx(new e.a(cFE.signature, cFE.vlD));
            jVar.vmZ.a(new 2(jVar, cFE));
            jVar.vmZ.execute();
        } else {
            c.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            jVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", cFE));
        }
    }
}
