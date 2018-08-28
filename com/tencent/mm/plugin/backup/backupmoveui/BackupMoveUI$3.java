package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveUI$3 implements OnClickListener {
    final /* synthetic */ BackupMoveUI gVE;

    BackupMoveUI$3(BackupMoveUI backupMoveUI) {
        this.gVE = backupMoveUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
        h.mEJ.a(485, 25, 1, false);
        b.arv().arw().stop();
        b.arv().arx().an(false);
        b.arv().aqP().gRC = -100;
        BackupMoveUI.c(this.gVE);
    }
}
