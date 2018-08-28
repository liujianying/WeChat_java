package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements e {
    final /* synthetic */ c gWG;

    c$3(c cVar) {
        this.gWG = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        c.anB();
        h.mEJ.h(13736, new Object[]{Integer.valueOf(0), c.e(this.gWG), g.cQ(ad.getContext()), Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
        b.b(1, c.f(this.gWG));
        if (i == 0 && i2 == 0) {
            a aVar = (a) lVar;
            x.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[]{Boolean.valueOf((aVar.gXu.hcF & c.gRr) != 0), Boolean.valueOf((aVar.gXu.hcF & c.gRs) != 0), Boolean.valueOf((aVar.gXu.hcF & c.gRt) != 0)});
            if ((aVar.gXu.hcF & c.gRt) != 0) {
                com.tencent.mm.bk.b bVar = aVar.gXu.hcH == null ? null : aVar.gXu.hcH;
                if (bVar != null) {
                    this.gWG.a(true, bVar);
                    b.arV().arX().gWR = r0;
                    b.arV().arX().gWS = r1;
                    return;
                }
                x.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
            }
            this.gWG.a(false, null);
            b.arV().arX().gWR = r0;
            b.arV().arX().gWS = r1;
            return;
        }
        x.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (i2) {
            case -3:
                h.mEJ.a(400, 115, 1, false);
                break;
            case -1:
                h.mEJ.a(400, 114, 1, false);
                break;
            default:
                h.mEJ.a(400, 116, 1, false);
                break;
        }
        h.mEJ.h(13737, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(this.gWG))});
        b.arV().aqP().gRC = -5;
        b.arV().arX().mH(-5);
    }
}
