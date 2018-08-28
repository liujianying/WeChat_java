package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveQRCodeUI$2 implements OnClickListener {
    final /* synthetic */ BackupMoveQRCodeUI gVq;

    BackupMoveQRCodeUI$2(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        this.gVq = backupMoveQRCodeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.arv().arw().stop();
        b.arv().arx().an(true);
        b.arv().aqP().gRC = -100;
        BackupMoveQRCodeUI.b(this.gVq);
    }
}
