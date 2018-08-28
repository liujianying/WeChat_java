package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ContactLabelEditUI$6 implements OnClickListener {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$6(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kAZ.setResult(0);
        this.kAZ.finish();
    }
}
