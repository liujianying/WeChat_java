package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class ContactLabelEditUI$3 implements OnCancelListener {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$3(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().cancel(635);
        au.DF().cancel(637);
    }
}
