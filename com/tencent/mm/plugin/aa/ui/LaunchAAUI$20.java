package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class LaunchAAUI$20 implements a<Void, d> {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$20(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        x.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
        if (dVar != null) {
            LaunchAAUI.a(this.eDS, dVar);
            if (!(bi.oW(LaunchAAUI.d(this.eDS).eAm) || bi.oW(LaunchAAUI.d(this.eDS).eAl))) {
                LaunchAAUI.a(this.eDS, LaunchAAUI.d(this.eDS).eAm, LaunchAAUI.d(this.eDS).eAl);
            }
        }
        return uQG;
    }
}
