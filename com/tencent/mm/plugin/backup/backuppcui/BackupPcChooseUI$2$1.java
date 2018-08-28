package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcChooseUI.2;
import com.tencent.mm.plugin.report.service.h;
import java.util.LinkedList;

class BackupPcChooseUI$2$1 implements OnClickListener {
    final /* synthetic */ LinkedList gXh;
    final /* synthetic */ LinkedList gXi;
    final /* synthetic */ 2 gXj;

    BackupPcChooseUI$2$1(2 2, LinkedList linkedList, LinkedList linkedList2) {
        this.gXj = 2;
        this.gXh = linkedList;
        this.gXi = linkedList2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.arV().arZ().C(this.gXh);
        b.arV().arW().mF(2);
        b.arV().aqP().gRC = 12;
        b.arV().arX().D(this.gXi);
        b.arV().arX().bV((long) this.gXh.size());
        h.mEJ.a(400, 8, 1, false);
        h.mEJ.h(13735, new Object[]{Integer.valueOf(10), Integer.valueOf(b.arV().arW().gWC)});
        if (BackupPcChooseUI.KD() == 1 && BackupPcChooseUI.asg() == 1) {
            h.mEJ.a(400, 32, 1, false);
            h.mEJ.a(400, 35, 1, false);
            h.mEJ.h(13735, new Object[]{Integer.valueOf(13), Integer.valueOf(b.arV().arW().gWC)});
        } else if (BackupPcChooseUI.KD() == 1) {
            h.mEJ.a(400, 32, 1, false);
            h.mEJ.h(13735, new Object[]{Integer.valueOf(11), Integer.valueOf(b.arV().arW().gWC)});
        } else if (BackupPcChooseUI.asg() == 1) {
            h.mEJ.a(400, 35, 1, false);
            h.mEJ.h(13735, new Object[]{Integer.valueOf(12), Integer.valueOf(b.arV().arW().gWC)});
        }
        this.gXj.gXg.finish();
    }
}
