package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ContactsSyncUI$3 implements OnClickListener {
    final /* synthetic */ ContactsSyncUI ePH;

    ContactsSyncUI$3(ContactsSyncUI contactsSyncUI) {
        this.ePH = contactsSyncUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ePH.finish();
    }
}
