package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallContactUI$3 implements OnClickListener {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$3(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kuK.finish();
        this.kuK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
