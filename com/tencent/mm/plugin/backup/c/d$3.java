package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ d gUG;

    d$3(d dVar) {
        this.gUG = dVar;
    }

    public final void mC(int i) {
        int i2 = b.arv().aqP().gRC;
        x.i("MicroMsg.BackupMoveServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 == 4) {
                    b.arv().aqP().gRC = 14;
                    this.gUG.mw(14);
                    return;
                }
                return;
            case 1:
                if (i2 == 14) {
                    b.arv().aqP().gRC = 4;
                    this.gUG.mw(4);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
