package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.16;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$16$1 implements OnClickListener {
    final /* synthetic */ 16 gXs;

    BackupPcUI$3$16$1(16 16) {
        this.gXs = 16;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
        b.arV().arw().stop();
        b.arV().arX().an(true);
        b.arV().aqP().gRC = -100;
        h.mEJ.a(400, 52, 1, false);
        b.arV().arX().mG(4);
        BackupPcUI.k(this.gXs.gXm.gXl);
    }
}
