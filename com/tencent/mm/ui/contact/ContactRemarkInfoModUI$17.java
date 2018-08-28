package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.ai;

class ContactRemarkInfoModUI$17 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$17(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        if (ai.oW(ContactRemarkInfoModUI.m(this.ujh)) || ContactRemarkInfoModUI.p(this.ujh)) {
            ContactRemarkInfoModUI.a(this.ujh, false);
            ContactRemarkInfoModUI.k(this.ujh);
        }
    }
}
