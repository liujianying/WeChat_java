package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements e {
    final /* synthetic */ c gUr;

    c$6(c cVar) {
        this.gUr = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        c.dv(true);
        h.mEJ.a(485, 42, 1, false);
        h.mEJ.h(11787, new Object[]{Integer.valueOf(0)});
        b.b(1, c.f(this.gUr));
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
            a aVar = (a) lVar;
            if (aVar.gXu.hcD < c.gRm) {
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[]{Integer.valueOf(aVar.gXu.hcD)});
                h.mEJ.a(485, 104, 1, false);
                b.arv().aqP().gRC = -12;
                this.gUr.mw(-12);
                return;
            }
            int i3 = aVar.gXu.hcE;
            c.a(this.gUr, (aVar.gXu.hcF & c.gRq) != 0);
            x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[]{Integer.valueOf(aVar.gXu.hcD), Integer.valueOf(i3), Boolean.valueOf(c.g(this.gUr))});
            if (i3 == c.gRo && c.arA()) {
                c.b(this.gUr, true);
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
            } else {
                this.gUr.arB();
                c.b(this.gUr, false);
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
            }
            c.h(this.gUr);
            b.a(3, c.i(this.gUr));
            new j(b.arv().gRu).ass();
            b.arv().aqP().gRC = 22;
            this.gUr.mw(22);
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
        b.arv().aqP().gRC = -5;
        this.gUr.mw(-5);
        this.gUr.mA(3);
    }
}
