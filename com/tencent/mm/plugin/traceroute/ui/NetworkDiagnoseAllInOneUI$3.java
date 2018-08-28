package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$3 implements a {
    final /* synthetic */ NetworkDiagnoseAllInOneUI oDK;

    NetworkDiagnoseAllInOneUI$3(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.oDK = networkDiagnoseAllInOneUI;
    }

    public final boolean vD() {
        NetworkDiagnoseAllInOneUI.a(this.oDK, NetworkDiagnoseAllInOneUI.k(this.oDK) + 1);
        x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.oDK))});
        if (NetworkDiagnoseAllInOneUI.k(this.oDK) > 99) {
            return false;
        }
        if (NetworkDiagnoseAllInOneUI.a(this.oDK) == 1) {
            NetworkDiagnoseAllInOneUI.l(this.oDK).setText(this.oDK.getString(R.l.diagnose_state_doing, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.oDK))}));
        }
        return true;
    }
}
