package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseAllInOneUI.2;

class NetworkDiagnoseAllInOneUI$2$1 implements Runnable {
    final /* synthetic */ 2 oDN;

    NetworkDiagnoseAllInOneUI$2$1(2 2) {
        this.oDN = 2;
    }

    public final void run() {
        NetworkDiagnoseAllInOneUI.h(this.oDN.oDK).setEnabled(true);
        if (NetworkDiagnoseAllInOneUI.i(this.oDN.oDK) != null && NetworkDiagnoseAllInOneUI.i(this.oDN.oDK).isShowing()) {
            NetworkDiagnoseAllInOneUI.i(this.oDN.oDK).dismiss();
        }
        NetworkDiagnoseAllInOneUI.b(this.oDN.oDK, 6);
        NetworkDiagnoseAllInOneUI.b(this.oDN.oDK);
    }
}
