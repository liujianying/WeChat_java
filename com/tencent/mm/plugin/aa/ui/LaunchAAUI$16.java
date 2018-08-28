package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.report.service.h;

class LaunchAAUI$16 implements a$a {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$16(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final void We() {
        this.eDS.startActivity(new Intent(this.eDS, AAQueryListUI.class));
        if (LaunchAAUI.b(this.eDS) == a.ezD) {
            h.mEJ.h(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
            return;
        }
        h.mEJ.h(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
    }
}
