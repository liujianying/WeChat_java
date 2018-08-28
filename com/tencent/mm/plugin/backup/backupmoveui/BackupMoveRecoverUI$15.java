package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class BackupMoveRecoverUI$15 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$15(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.gVy = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11789, new Object[]{Integer.valueOf(7)});
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.setFlags(268435456);
        d.b(this.gVy.mController.tml, "scanner", ".ui.BaseScanUI", intent);
    }
}
