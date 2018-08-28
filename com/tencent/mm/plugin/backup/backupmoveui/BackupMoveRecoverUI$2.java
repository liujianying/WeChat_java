package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class BackupMoveRecoverUI$2 implements OnClickListener {
    final /* synthetic */ int gUs;
    final /* synthetic */ BackupMoveRecoverUI gVy;

    BackupMoveRecoverUI$2(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.gVy = backupMoveRecoverUI;
        this.gUs = i;
    }

    public final void onClick(View view) {
        h.a(this.gVy, R.l.backup_move_error_alert_stop_move_tip, R.l.backup_move_error_alert_stop_move, R.l.backup_move_recover_stop_move, R.l.backup_cancel, false, new 1(this), null, R.e.backup_red);
    }
}
