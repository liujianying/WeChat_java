package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class NetworkDiagnoseAllInOneUI$5 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseAllInOneUI oDK;

    NetworkDiagnoseAllInOneUI$5(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.oDK = networkDiagnoseAllInOneUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oDK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
