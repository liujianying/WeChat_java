package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.13;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$13$1 implements OnClickListener {
    final /* synthetic */ 13 gXr;

    BackupPcUI$3$13$1(13 13) {
        this.gXr = 13;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
        h.mEJ.a(400, 26, 1, false);
        b.arV().arw().stop();
        b.arV().arY().a(true, true, -100);
    }
}
