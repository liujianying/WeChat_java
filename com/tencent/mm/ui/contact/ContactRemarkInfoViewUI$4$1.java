package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.4;

class ContactRemarkInfoViewUI$4$1 implements Runnable {
    final /* synthetic */ boolean hMY;
    final /* synthetic */ 4 ujn;

    ContactRemarkInfoViewUI$4$1(4 4, boolean z) {
        this.ujn = 4;
        this.hMY = z;
    }

    public final void run() {
        if (this.hMY) {
            ContactRemarkInfoViewUI.e(this.ujn.ujm);
        } else {
            h.bA(this.ujn.ujm, this.ujn.ujm.getString(R.l.app_err_system_busy_tip));
        }
    }
}
