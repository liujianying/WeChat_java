package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class BackupMoveRecoverUI$12 implements OnClickListener {
    final /* synthetic */ int gUs;
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$12(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.gVy = backupMoveRecoverUI;
        this.gUs = i;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupMoveRecoverUI", "backupmove click stop merge button.");
        h.a(this.gVy, R.l.backup_move_error_alert_stop_merge_tip, R.l.backup_move_error_alert_stop_merge, R.l.backup_move_recover_stop_merge, R.l.backup_cancel, false, new 1(this), null, R.e.backup_red);
    }
}
