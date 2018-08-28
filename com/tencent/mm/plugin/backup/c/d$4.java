package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements a {
    final /* synthetic */ d gUG;

    d$4(d dVar) {
        this.gUG = dVar;
    }

    public final void arG() {
        this.gUG.mw(b.arv().aqP().gRC);
    }

    public final void mB(int i) {
    }

    public final void arH() {
        int i = b.arv().aqP().gRC;
        x.e("MicroMsg.BackupMoveServer", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
        if (i == 14 || i == 4) {
            this.gUG.an(true);
            b.arv().arw().stop();
            b.arv().aqP().gRC = -4;
            this.gUG.mw(-4);
        }
    }
}
