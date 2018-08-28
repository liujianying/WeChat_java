package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.b.b.a;
import com.tencent.d.b.d.b;
import com.tencent.d.b.e.e;

public final class j extends c {
    e vmZ = null;
    private boolean vna = false;

    public j(e eVar, boolean z) {
        this.vmZ = eVar;
        this.vna = z;
    }

    final boolean cFX() {
        if (!a.cFO().isInit()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (!a.cFO().cFN()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        } else if (!com.tencent.d.a.a.cFD() || this.vna) {
            if (this.vmZ == null) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            return false;
        } else {
            c.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            b(new com.tencent.d.b.a.c(com.tencent.d.a.a.cFE()));
            return true;
        }
    }

    final void cFY() {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        com.tencent.d.a.a.cFB();
    }

    final void execute() {
        dC(d.cFJ().vly, 1);
        b.a aVar = new b.a();
        boolean z = this.vna;
        aVar.vlU |= 1;
        aVar.vlW = z;
        aVar.vlY = new 1(this);
        aVar.cFV().cFU();
    }
}
