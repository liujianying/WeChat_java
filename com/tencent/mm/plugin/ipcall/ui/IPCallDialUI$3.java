package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallDialUI$3 implements OnClickListener {
    final /* synthetic */ IPCallDialUI kvy;

    IPCallDialUI$3(IPCallDialUI iPCallDialUI) {
        this.kvy = iPCallDialUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kvy.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
