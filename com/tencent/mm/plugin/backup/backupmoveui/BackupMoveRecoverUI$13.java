package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveRecoverUI$13 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$13(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        b.arv().aqP().gRC = 25;
        BackupMoveRecoverUI.a(this.gVy);
    }
}
