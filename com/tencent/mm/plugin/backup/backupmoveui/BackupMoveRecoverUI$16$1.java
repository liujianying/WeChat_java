package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.16;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupMoveRecoverUI$16$1 implements OnClickListener {
    final /* synthetic */ 16 gVD;

    BackupMoveRecoverUI$16$1(16 16) {
        this.gVD = 16;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupMoveRecoverUI", "user click close. stop recover, backupState[%d].", new Object[]{Integer.valueOf(this.gVD.gUs)});
        h.mEJ.a(485, 44, 1, false);
        b.arv().ary().mA(6);
        b.arv().arw().stop();
        b.arv().ary().a(true, true, -100);
    }
}
