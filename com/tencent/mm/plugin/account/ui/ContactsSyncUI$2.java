package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ContactsSyncUI$2 implements OnClickListener {
    final /* synthetic */ ContactsSyncUI ePH;

    ContactsSyncUI$2(ContactsSyncUI contactsSyncUI) {
        this.ePH = contactsSyncUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ePH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
