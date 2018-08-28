package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.2;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 gVz;

    BackupMoveRecoverUI$2$1(2 2) {
        this.gVz = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(this.gVz.gUs)});
        h.mEJ.a(485, 44, 1, false);
        b.arv().ary().mA(5);
        b.arv().arw().stop();
        b.arv().ary().a(true, true, -100);
    }
}
