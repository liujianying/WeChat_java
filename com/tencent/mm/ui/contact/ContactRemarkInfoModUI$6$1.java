package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI.6;

class ContactRemarkInfoModUI$6$1 implements Runnable {
    final /* synthetic */ boolean hMY;
    final /* synthetic */ 6 uji;

    ContactRemarkInfoModUI$6$1(6 6, boolean z) {
        this.uji = 6;
        this.hMY = z;
    }

    public final void run() {
        if (this.hMY) {
            this.uji.ujh.cyf();
            return;
        }
        h.bA(this.uji.ujh, this.uji.ujh.getString(R.l.app_err_system_busy_tip));
        this.uji.ujh.uiN.setVisibility(0);
        this.uji.ujh.uiK.setVisibility(8);
        this.uji.ujh.uiM.setVisibility(8);
    }
}
