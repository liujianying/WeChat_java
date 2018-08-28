package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.ad;

class ContactLabelManagerUI$2 implements OnClickListener {
    final /* synthetic */ ContactLabelManagerUI kBk;
    final /* synthetic */ ad kBl;

    ContactLabelManagerUI$2(ContactLabelManagerUI contactLabelManagerUI, ad adVar) {
        this.kBk = contactLabelManagerUI;
        this.kBl = adVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kBl == null) {
            return;
        }
        if (this.kBl.field_isTemporary) {
            ContactLabelManagerUI.a(this.kBk, this.kBl.field_labelID);
        } else {
            ContactLabelManagerUI.a(this.kBk, this.kBl);
        }
    }
}
