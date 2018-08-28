package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$11 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$11(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupMoveRecoverUI", "backupmove click start merge button.");
        b.arv().ary();
        if (c.arA()) {
            b.arv().ary().arg();
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
        b.arv().aqP().gRC = -22;
        this.gVy.mw(-22);
        h.mEJ.a(485, 6, 1, false);
    }
}
