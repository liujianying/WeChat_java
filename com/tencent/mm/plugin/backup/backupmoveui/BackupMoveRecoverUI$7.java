package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$7 implements OnClickListener {
    final /* synthetic */ int gVB;
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$7(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.gVy = backupMoveRecoverUI;
        this.gVB = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover move, backupState[%d].", new Object[]{Integer.valueOf(this.gVB)});
        h.mEJ.a(485, 44, 1, false);
        b.arv().ary().mA(5);
        b.arv().arw().stop();
        b.arv().ary().a(true, true, -100);
    }
}
