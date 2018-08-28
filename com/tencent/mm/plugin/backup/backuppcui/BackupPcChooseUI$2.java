package com.tencent.mm.plugin.backup.backuppcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class BackupPcChooseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupPcChooseUI gXg;

    BackupPcChooseUI$2(BackupPcChooseUI backupPcChooseUI) {
        this.gXg = backupPcChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LinkedList linkedList;
        a a = BackupPcChooseUI.a(this.gXg);
        LinkedList linkedList2 = new LinkedList();
        if (a.gUV.size() <= 0) {
            linkedList = linkedList2;
        } else {
            LinkedList arr = b.arV().arZ().arr();
            if (arr != null) {
                for (int i = 0; i < a.getCount(); i++) {
                    if (a.gUV.contains(Integer.valueOf(i))) {
                        linkedList2.add(arr.get(i));
                    }
                }
            }
            x.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
            linkedList = linkedList2;
        }
        LinkedList x = g.x(linkedList);
        au.HU();
        x.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) c.DT().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()), Integer.valueOf(BackupPcChooseUI.KD()), Long.valueOf(BackupPcChooseUI.JD()), Long.valueOf(BackupPcChooseUI.arN()), Integer.valueOf(BackupPcChooseUI.asg()));
        if (((Boolean) c.DT().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            h.a(this.gXg, R.l.backup_pc_has_move_tip, 0, R.l.backup_sure, 0, false, new 1(this, linkedList, x), null, R.e.backup_green);
        } else {
            b.arV().arZ().C(linkedList);
            b.arV().arW().mF(2);
            b.arV().aqP().gRC = 12;
            b.arV().arX().D(x);
            b.arV().arX().bV((long) linkedList.size());
            com.tencent.mm.plugin.report.service.h.mEJ.a(400, 8, 1, false);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13735, Integer.valueOf(10), Integer.valueOf(b.arV().arW().gWC));
            if (BackupPcChooseUI.KD() == 1 && BackupPcChooseUI.asg() == 1) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(400, 32, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.a(400, 35, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13735, Integer.valueOf(13), Integer.valueOf(b.arV().arW().gWC));
            } else if (BackupPcChooseUI.KD() == 1) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(400, 32, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13735, Integer.valueOf(11), Integer.valueOf(b.arV().arW().gWC));
            } else if (BackupPcChooseUI.asg() == 1) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(400, 35, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13735, Integer.valueOf(12), Integer.valueOf(b.arV().arW().gWC));
            }
            this.gXg.finish();
        }
        return true;
    }
}
