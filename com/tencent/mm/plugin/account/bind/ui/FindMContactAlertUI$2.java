package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FindMContactAlertUI$2 implements OnClickListener {
    final /* synthetic */ FindMContactAlertUI eHH;

    FindMContactAlertUI$2(FindMContactAlertUI findMContactAlertUI) {
        this.eHH = findMContactAlertUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.eHH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
