package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ContactRemarkInfoModUI$12 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$12(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        ContactRemarkInfoModUI.f(this.ujh);
        ContactRemarkInfoModUI.a(this.ujh, false, view.getId());
        ContactRemarkInfoModUI.g(this.ujh).performClick();
        ContactRemarkInfoModUI.g(this.ujh).requestFocus();
        this.ujh.showVKB();
    }
}
