package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b$b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

class e$5 implements b$b {
    final /* synthetic */ e gWV;

    e$5(e eVar) {
        this.gWV = eVar;
    }

    public final void mw(int i) {
        Set hashSet = new HashSet();
        hashSet.addAll(e.d(this.gWV));
        ah.A(new 1(this, hashSet, i));
        if (e.e(this.gWV) != null) {
            ah.A(new 2(this, i));
        }
    }

    public final void aqL() {
        h.mEJ.a(400, 11, 1, false);
        h.mEJ.a(400, 12, e.b(this.gWV) == null ? 0 : bi.bH(e.b(this.gWV).gSk) / 1000, false);
        h.mEJ.a(400, 13, e.b(this.gWV) == null ? 0 : e.b(this.gWV).arc(), false);
        this.gWV.mG(0);
        if (!e.f(this.gWV)) {
            this.gWV.mG(21);
        }
    }

    public final void aqM() {
        x.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[]{Boolean.valueOf(false)});
        this.gWV.an(false);
        h.mEJ.a(400, 120, 1, false);
    }
}
