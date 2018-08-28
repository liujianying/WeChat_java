package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$8 implements OnClickListener {
    final /* synthetic */ int gVB;
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$8(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.gVy = backupMoveRecoverUI;
        this.gVB = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover merge, backupState[%d]", new Object[]{Integer.valueOf(this.gVB)});
        h.mEJ.a(485, 48, 1, false);
        b.arv().arw().stop();
        b.arv().ary().a(true, true, -100);
    }
}
