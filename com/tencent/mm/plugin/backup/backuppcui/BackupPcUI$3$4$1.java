package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.4;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$4$1 implements OnClickListener {
    final /* synthetic */ 4 gXq;

    BackupPcUI$3$4$1(4 4) {
        this.gXq = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
        h.mEJ.a(400, 18, 1, false);
        b.arV().arY().mG(4);
        b.arV().arw().stop();
        b.arV().arY().a(true, true, -100);
    }
}
