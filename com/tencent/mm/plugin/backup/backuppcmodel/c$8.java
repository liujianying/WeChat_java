package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$8 implements a {
    final /* synthetic */ c gWG;

    c$8(c cVar) {
        this.gWG = cVar;
    }

    public final void asc() {
        x.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        if (b.arV().aqP().gRC != 5) {
            b.arV().aqP().gRC = 5;
            int i = b.arV().arW().gWw;
            if (1 == i || 3 == i) {
                b.arV().arX().mH(5);
            } else if (2 == i || 4 == i) {
                b.arV().arY().mw(5);
            }
        }
        this.gWG.mF(9);
    }

    public final void asd() {
        int i = b.arV().arW().gWw;
        x.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i) {
            b.arV().arX();
            e.asf();
            b.arV().arX().an(true);
            b.arV().arw().stop();
            b.arV().aqP().gRC = -4;
            b.arV().arX().mH(-4);
            h.mEJ.a(400, 9, 1, false);
            b.arV().arX().mG(3);
        } else if (2 == i || 4 == i) {
            b.arV().arY();
            d.ase();
            b.arV().arY().a(true, false, -4);
            b.arV().arw().stop();
            h.mEJ.a(400, 17, 1, false);
            b.arV().arY().mG(3);
        }
    }
}
