package com.tencent.mm.plugin.backup.backupmoveui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;

class BackupUI$4 implements a {
    final /* synthetic */ BackupUI gVH;

    BackupUI$4(BackupUI backupUI) {
        this.gVH = backupUI;
    }

    public final boolean vD() {
        if (bi.oW(g.cQ(this.gVH))) {
            if (BackupUI.yT()) {
                BackupUI.a(this.gVH).setText(R.l.backup_status_content_no_wifi);
                BackupUI.a(this.gVH).setTextColor(this.gVH.getResources().getColor(R.e.backup_red));
                BackupUI.b(this.gVH).setEnabled(false);
                BackupUI.aZ(false);
                h.mEJ.h(11788, new Object[]{Integer.valueOf(2)});
            }
        } else if (!BackupUI.yT()) {
            BackupUI.a(this.gVH).setText(R.l.backup_status_content_open_wifi);
            BackupUI.a(this.gVH).setTextColor(this.gVH.getResources().getColor(R.e.backup_green));
            BackupUI.b(this.gVH).setEnabled(true);
            BackupUI.aZ(true);
        }
        return true;
    }
}
