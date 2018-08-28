package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.2;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$2$1 implements OnClickListener {
    final /* synthetic */ 2 gXo;

    BackupPcUI$3$2$1(2 2) {
        this.gXo = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
        b.arV().arw().stop();
        b.arV().arY().a(true, true, -100);
        h.mEJ.a(400, 52, 1, false);
        b.arV().arY().mG(4);
    }
}
