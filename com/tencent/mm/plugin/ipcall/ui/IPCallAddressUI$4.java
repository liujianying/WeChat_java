package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallAddressUI$4 implements OnClickListener {
    final /* synthetic */ IPCallAddressUI kur;

    IPCallAddressUI$4(IPCallAddressUI iPCallAddressUI) {
        this.kur = iPCallAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.kur.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
