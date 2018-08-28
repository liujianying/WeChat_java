package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$5 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$5(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "move phone old version");
        BackupMoveRecoverUI.c(this.gVy);
    }
}
