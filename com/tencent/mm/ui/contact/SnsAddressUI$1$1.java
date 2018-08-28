package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.SnsAddressUI.1;

class SnsAddressUI$1$1 implements Runnable {
    final /* synthetic */ 1 ulT;

    SnsAddressUI$1$1(1 1) {
        this.ulT = 1;
    }

    public final void run() {
        if (!this.ulT.ulS.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            this.ulT.ulS.moveTaskToBack(true);
        }
    }
}
