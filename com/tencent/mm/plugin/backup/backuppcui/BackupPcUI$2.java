package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$2 implements OnClickListener {
    final /* synthetic */ BackupPcUI gXl;

    BackupPcUI$2(BackupPcUI backupPcUI) {
        this.gXl = backupPcUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
        h.mEJ.a(400, 26, 1, false);
        b.arV().arw().stop();
        b.arV().arY().a(true, true, -100);
    }
}
