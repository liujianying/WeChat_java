package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$10 implements Runnable {
    final /* synthetic */ a uhE;

    AddressUI$a$10(a aVar) {
        this.uhE = aVar;
    }

    public final void run() {
        x.v("MicroMsg.AddressUI", "post search adapter to do refresh");
        a.g(this.uhE).a(null, null);
    }
}
