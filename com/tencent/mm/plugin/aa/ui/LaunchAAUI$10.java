package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class LaunchAAUI$10 implements a<Void, Boolean> {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$10(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", (Boolean) obj);
        if (LaunchAAUI.k(this.eDS) != null) {
            LaunchAAUI.k(this.eDS).dismiss();
        }
        if (r7.booleanValue()) {
            LaunchAAUI.l(this.eDS);
            Toast.makeText(this.eDS, i.launch_aa_success, 1).show();
            h.mEJ.h(13722, Integer.valueOf(4));
        } else {
            Toast.makeText(this.eDS, i.launch_aa_failed, 1).show();
            h.mEJ.h(13722, Integer.valueOf(5));
        }
        return uQG;
    }
}
