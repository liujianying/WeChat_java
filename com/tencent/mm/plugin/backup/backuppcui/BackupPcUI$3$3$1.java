package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.3;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$3$1 implements OnClickListener {
    final /* synthetic */ 3 gXp;

    BackupPcUI$3$3$1(3 3) {
        this.gXp = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
        h.mEJ.a(400, 10, 1, false);
        b.arV().arX().mG(4);
        b.arV().arw().stop();
        b.arV().arX().an(true);
        b.arV().aqP().gRC = -100;
        BackupPcUI.l(this.gXp.gXm.gXl);
    }
}
