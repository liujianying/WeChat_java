package com.tencent.mm.ui.contact;

import android.os.Process;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$13 implements Runnable {
    final /* synthetic */ a uhE;

    AddressUI$a$13(a aVar) {
        this.uhE = aVar;
    }

    public final void run() {
        Process.setThreadPriority(10);
        a.p(this.uhE);
    }
}
