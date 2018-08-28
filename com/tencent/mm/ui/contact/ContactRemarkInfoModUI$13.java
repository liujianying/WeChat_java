package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ContactRemarkInfoModUI$13 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$13(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        ContactRemarkInfoModUI.f(this.ujh);
        ContactRemarkInfoModUI.a(this.ujh, false, view.getId());
        ContactRemarkInfoModUI.h(this.ujh).performClick();
        ContactRemarkInfoModUI.h(this.ujh).requestFocus();
        this.ujh.showVKB();
    }
}
