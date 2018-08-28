package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.d;

class LaunchAAUI$13 implements a<Void, d<Boolean, String, Long>> {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$13(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", new Object[]{((d) obj).get(0)});
        if (LaunchAAUI.k(this.eDS) != null) {
            LaunchAAUI.k(this.eDS).dismiss();
        }
        if (((Boolean) r8.get(0)).booleanValue()) {
            LaunchAAUI.l(this.eDS);
            Toast.makeText(this.eDS, i.launch_aa_success, 1).show();
            h.mEJ.h(13722, new Object[]{Integer.valueOf(9)});
        } else {
            Toast.makeText(this.eDS, i.launch_aa_failed, 1).show();
            h.mEJ.h(13722, new Object[]{Integer.valueOf(10)});
        }
        return uQG;
    }
}
