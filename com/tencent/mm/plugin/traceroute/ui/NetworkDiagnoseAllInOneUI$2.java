package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$2 implements a {
    final /* synthetic */ NetworkDiagnoseAllInOneUI oDK;

    NetworkDiagnoseAllInOneUI$2(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.oDK = networkDiagnoseAllInOneUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        String str;
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[]{Boolean.valueOf(z)});
        NetworkDiagnoseAllInOneUI.g(this.oDK).c(NetworkDiagnoseAllInOneUI.f(this.oDK));
        ah.A(new 1(this));
        NetworkDiagnoseAllInOneUI.j(this.oDK);
        if (z) {
            str = (String.valueOf(f2) + "-" + String.valueOf(f)) + "," + NetworkDiagnoseAllInOneUI.j(this.oDK);
        } else {
            x.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
            str = "," + NetworkDiagnoseAllInOneUI.j(this.oDK);
        }
        h.mEJ.k(14533, str);
        return false;
    }
}
