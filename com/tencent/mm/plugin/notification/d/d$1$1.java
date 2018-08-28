package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.plugin.notification.d.d.1;

class d$1$1 implements Runnable {
    final /* synthetic */ ox lHN;
    final /* synthetic */ 1 lHO;

    d$1$1(1 1, ox oxVar) {
        this.lHO = 1;
        this.lHN = oxVar;
    }

    public final void run() {
        cm cmVar = this.lHN.bZS.bGS;
        if (d.IT(cmVar.field_talker)) {
            this.lHO.lHM.bJ(cmVar);
        }
    }
}
