package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;

class BackupPcUI$3$10 implements OnClickListener {
    final /* synthetic */ 3 gXm;

    BackupPcUI$3$10(3 3) {
        this.gXm = 3;
    }

    public final void onClick(View view) {
        b.arV().arw().stop();
        b.arV().arX().an(true);
        b.arV().aqP().gRC = -100;
        BackupPcUI.g(this.gXm.gXl);
    }
}
