package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BackupPcUI$3$12 implements OnClickListener {
    final /* synthetic */ 3 gXm;

    BackupPcUI$3$12(3 3) {
        this.gXm = 3;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
        b.arV().arY();
        if (!d.arA()) {
            b.arV().arY();
            if (!d.arA()) {
                b.arV().aqP().gRC = -22;
                this.gXm.mw(-22);
                h.mEJ.a(400, 64, 1, false);
                return;
            }
        }
        h.mEJ.h(13735, new Object[]{Integer.valueOf(27), Integer.valueOf(b.arV().arW().gWC)});
        b.arV().arY().arg();
    }
}
