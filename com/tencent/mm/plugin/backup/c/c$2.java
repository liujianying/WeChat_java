package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c gUr;

    c$2(c cVar) {
        this.gUr = cVar;
    }

    public final void arG() {
        this.gUr.mw(b.arv().aqP().gRC);
    }

    public final void mB(int i) {
        if (i == 1) {
            h.mEJ.h(11789, new Object[]{Integer.valueOf(8)});
        } else if (i == 0) {
            h.mEJ.h(11789, new Object[]{Integer.valueOf(9)});
        }
    }

    public final void arH() {
        int i = b.arv().aqP().gRC;
        x.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
        if (i == 23 || i == 4) {
            this.gUr.a(true, false, -4);
            h.mEJ.a(485, 43, 1, false);
            this.gUr.mA(4);
            b.arv().arw().stop();
        }
    }
}
