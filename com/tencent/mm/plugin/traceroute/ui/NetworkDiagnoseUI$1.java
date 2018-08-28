package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class NetworkDiagnoseUI$1 implements a {
    final /* synthetic */ NetworkDiagnoseUI oEe;

    NetworkDiagnoseUI$1(NetworkDiagnoseUI networkDiagnoseUI) {
        this.oEe = networkDiagnoseUI;
    }

    public final boolean vD() {
        NetworkDiagnoseUI.a(this.oEe, NetworkDiagnoseUI.a(this.oEe) + 1);
        NetworkDiagnoseUI.b(this.oEe, NetworkDiagnoseUI.b(this.oEe));
        if (NetworkDiagnoseUI.b(this.oEe) < 100) {
            NetworkDiagnoseUI.c(this.oEe).setProgress(NetworkDiagnoseUI.b(this.oEe));
            return true;
        }
        NetworkDiagnoseUI.c(this.oEe).setProgress(100);
        return false;
    }
}
