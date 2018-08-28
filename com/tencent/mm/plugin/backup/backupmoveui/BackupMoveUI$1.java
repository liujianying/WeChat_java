package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveUI$1 implements OnClickListener {
    final /* synthetic */ BackupMoveUI gVE;

    BackupMoveUI$1(BackupMoveUI backupMoveUI) {
        this.gVE = backupMoveUI;
    }

    public final void onClick(View view) {
        b.arv().arw().stop();
        b.arv().arx().an(true);
        b.arv().aqP().gRC = -100;
        BackupMoveUI.a(this.gVE);
    }
}
