package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class NetworkDiagnoseUI$7 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseUI oEe;

    NetworkDiagnoseUI$7(NetworkDiagnoseUI networkDiagnoseUI) {
        this.oEe = networkDiagnoseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NetworkDiagnoseUI.e(this.oEe);
        this.oEe.finish();
    }
}
