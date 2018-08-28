package com.tencent.mm.plugin.backup.backuppcui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class BackupPcChooseUI$5 implements a {
    final /* synthetic */ BackupPcChooseUI gXg;

    BackupPcChooseUI$5(BackupPcChooseUI backupPcChooseUI) {
        this.gXg = backupPcChooseUI;
    }

    public final void y(LinkedList<b> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                BackupPcChooseUI.b(this.gXg).setVisibility(8);
                BackupPcChooseUI.c(this.gXg).setVisibility(0);
                switch (BackupPcChooseUI.KD()) {
                    case 0:
                        BackupPcChooseUI.c(this.gXg).setText(R.l.backup_pc_choose_empty_records);
                        return;
                    case 1:
                        BackupPcChooseUI.c(this.gXg).setText(R.l.backup_select_empty_records_in_select_time);
                        return;
                    default:
                        return;
                }
            }
            BackupPcChooseUI.d(this.gXg).setClickable(true);
            BackupPcChooseUI.b(this.gXg).setVisibility(4);
            BackupPcChooseUI.a(this.gXg).notifyDataSetChanged();
        }
    }
}
