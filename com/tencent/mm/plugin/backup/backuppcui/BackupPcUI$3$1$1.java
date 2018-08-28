package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3.1;
import com.tencent.mm.plugin.report.service.h;

class BackupPcUI$3$1$1 implements OnClickListener {
    final /* synthetic */ 1 gXn;

    BackupPcUI$3$1$1(1 1) {
        this.gXn = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.arV().arW().mF(2);
        b.arV().aqP().gRC = 12;
        this.gXn.gXm.mw(12);
        b.arV().arZ().art();
        b.arV().arZ().dy(true);
        h.mEJ.a(400, 7, 1, false);
        h.mEJ.h(13735, new Object[]{Integer.valueOf(9), Integer.valueOf(b.arV().arW().gWC)});
    }
}
