package com.tencent.mm.plugin.traceroute.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class NetworkDiagnoseUI$2 extends ag {
    final /* synthetic */ NetworkDiagnoseUI oEe;

    NetworkDiagnoseUI$2(NetworkDiagnoseUI networkDiagnoseUI) {
        this.oEe = networkDiagnoseUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                NetworkDiagnoseUI.e(this.oEe);
                if (NetworkDiagnoseUI.b(this.oEe) < 95) {
                    NetworkDiagnoseUI.c(this.oEe).setProgress(95);
                }
                NetworkDiagnoseUI.d(this.oEe).bIM();
                return;
            case 2:
                if (NetworkDiagnoseUI.b(this.oEe) < 95) {
                    NetworkDiagnoseUI.c(this.oEe).setProgress(95);
                }
                NetworkDiagnoseUI.d(this.oEe).bIM();
                return;
            case 3:
                NetworkDiagnoseUI.c(this.oEe).setProgress(100);
                NetworkDiagnoseUI.a(this.oEe, false);
                return;
            case 4:
                NetworkDiagnoseUI.c(this.oEe).setProgress(100);
                NetworkDiagnoseUI.a(this.oEe, true);
                return;
            default:
                return;
        }
    }
}
