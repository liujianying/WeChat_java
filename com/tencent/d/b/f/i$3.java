package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.b.a;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.d;

class i$3 implements b<d.b> {
    final /* synthetic */ i vmY;

    i$3(i iVar) {
        this.vmY = iVar;
    }

    public final /* synthetic */ void cG(Object obj) {
        c.i("Soter.TaskInit", "soter: got support tag from backend: %b", new Object[]{Boolean.valueOf(((d.b) obj).cbY)});
        synchronized (a.class) {
            a.cFO().mQ(r6.cbY);
            a.cFO().cFP();
        }
        this.vmY.b(new com.tencent.d.b.a.d(0));
    }
}
