package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class LaunchAAUI$11 implements a {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$11(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final void bd(Object obj) {
        x.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
        if (LaunchAAUI.k(this.eDS) != null) {
            LaunchAAUI.k(this.eDS).dismiss();
        }
        if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
            Toast.makeText(this.eDS, obj.toString(), 1).show();
        } else if (obj == null || !(obj instanceof y)) {
            Toast.makeText(this.eDS, i.launch_aa_failed, 1).show();
        } else {
            h.a(this.eDS.mController.tml, (y) obj);
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(13722, Integer.valueOf(10));
    }
}
