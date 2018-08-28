package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;
import com.tencent.mm.ui.base.h;

class BackupPcUI$3$4 implements OnClickListener {
    final /* synthetic */ 3 gXm;

    BackupPcUI$3$4(3 3) {
        this.gXm = 3;
    }

    public final void onClick(View view) {
        h.a(this.gXm.gXl, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new 1(this), null, R.e.backup_red);
    }
}
