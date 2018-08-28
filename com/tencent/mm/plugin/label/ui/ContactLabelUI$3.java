package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ContactLabelUI$3 implements OnClickListener {
    final /* synthetic */ ContactLabelUI kBX;

    ContactLabelUI$3(ContactLabelUI contactLabelUI) {
        this.kBX = contactLabelUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kBX.finish();
    }
}
