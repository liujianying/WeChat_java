package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

class BackupUI$1$1 implements OnClickListener {
    final /* synthetic */ int gVI;
    final /* synthetic */ 1 gVJ;

    BackupUI$1$1(1 1, int i) {
        this.gVJ = 1;
        this.gVI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", new Object[]{Integer.valueOf(this.gVI)});
        h.mEJ.a(485, 21, 1, false);
        h.mEJ.h(11788, new Object[]{Integer.valueOf(3)});
        MMWizardActivity.D(this.gVJ.gVH, new Intent(this.gVJ.gVH, BackupMoveChooseUI.class));
    }
}
