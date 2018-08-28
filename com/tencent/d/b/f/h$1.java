package com.tencent.d.b.f;

import com.tencent.d.a.c.f;
import com.tencent.d.b.a.a;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.c;

class h$1 implements b<c.b> {
    final /* synthetic */ h vmN;

    h$1(h hVar) {
        this.vmN = hVar;
    }

    public final /* synthetic */ void cG(Object obj) {
        c.b bVar = (c.b) obj;
        if (f.oW(bVar.jgX)) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
            this.vmN.b(new a(19));
            return;
        }
        this.vmN.pIu = bVar.jgX;
        this.vmN.cGc();
    }
}
