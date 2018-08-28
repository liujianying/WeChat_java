package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$6 implements Runnable {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$6(a aVar) {
        this.ulb = aVar;
    }

    public final void run() {
        x.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
        a.d(this.ulb).a(null, null);
    }
}
