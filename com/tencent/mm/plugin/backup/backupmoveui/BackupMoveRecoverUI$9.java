package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$9 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$9(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupMoveRecoverUI", "minimize BackupMoveRecoverUI");
        BackupMoveRecoverUI.e(this.gVy);
    }
}
