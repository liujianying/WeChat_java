package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.f.f$a;
import com.tencent.mm.sdk.platformtools.x;

class c$12 implements f$a {
    final /* synthetic */ c gUr;

    c$12(c cVar) {
        this.gUr = cVar;
    }

    public final void mC(int i) {
        int i2 = b.arv().aqP().gRC;
        x.i("MicroMsg.BackupMoveRecoverServer", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 == 4) {
                    b.arv().aqP().gRC = 23;
                    this.gUr.mw(23);
                    return;
                }
                return;
            case 1:
                if (i2 == 23) {
                    b.arv().aqP().gRC = 4;
                    this.gUr.mw(4);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
