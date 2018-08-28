package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;

class BackupPcChooseUI$4 implements OnClickListener {
    final /* synthetic */ BackupPcChooseUI gXg;

    BackupPcChooseUI$4(BackupPcChooseUI backupPcChooseUI) {
        this.gXg = backupPcChooseUI;
    }

    public final void onClick(View view) {
        int i = 0;
        if (b.arV().arZ().gTz) {
            a a = BackupPcChooseUI.a(this.gXg);
            if (a.gUV.size() == a.getCount()) {
                a.gUV.clear();
                a.gXb = false;
            } else {
                while (i < a.getCount()) {
                    a.gUV.add(Integer.valueOf(i));
                    i++;
                }
                a.gXb = true;
            }
            a.notifyDataSetChanged();
            a.gXa.a(a.gUV);
        }
    }
}
