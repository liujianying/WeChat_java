package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.b;
import com.tencent.mm.plugin.report.service.h;

class a$3 implements b {
    final /* synthetic */ a lHC;

    a$3(a aVar) {
        this.lHC = aVar;
    }

    public final void bkr() {
        h.mEJ.h(11425, new Object[]{Integer.valueOf(this.lHC.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        this.lHC.bkm();
        this.lHC.bko();
        if (!this.lHC.lHv) {
            this.lHC.lHu.dismiss();
        }
    }
}
