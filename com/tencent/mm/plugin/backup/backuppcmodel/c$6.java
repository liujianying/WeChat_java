package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.f$a;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements f$a {
    final /* synthetic */ c gWG;

    c$6(c cVar) {
        this.gWG = cVar;
    }

    public final void mC(int i) {
        int i2 = b.arV().aqP().gRC;
        x.i("MicroMsg.BackupPcProcessMgr", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 != 4) {
                    return;
                }
                if (1 == b.arV().arW().gWw) {
                    b.arV().aqP().gRC = 14;
                    b.arV().arX().mH(14);
                    return;
                } else if (2 == b.arV().arW().gWw) {
                    b.arV().aqP().gRC = 23;
                    b.arV().arY().mw(23);
                    return;
                } else {
                    return;
                }
            case 1:
                if (i2 == 14 || i2 == 23) {
                    b.arV().aqP().gRC = 4;
                    if (1 == b.arV().arW().gWw) {
                        b.arV().arX().mH(4);
                        return;
                    } else if (2 == b.arV().arW().gWw) {
                        b.arV().arY().mw(4);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
