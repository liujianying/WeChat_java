package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$2 implements Runnable {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$2(a aVar) {
        this.ulb = aVar;
    }

    public final void run() {
        a.c(this.ulb).setSelection(0);
    }
}
