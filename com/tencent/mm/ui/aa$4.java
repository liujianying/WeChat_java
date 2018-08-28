package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

class aa$4 implements Runnable {
    final /* synthetic */ aa toC;

    aa$4(aa aaVar) {
        this.toC = aaVar;
    }

    public final void run() {
        int f;
        if (au.HX()) {
            au.HU();
            f = ai.f((Integer) c.DT().get(143618, null));
        } else {
            x.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
            f = 0;
        }
        if (this.toC.tow != null) {
            this.toC.tow.DE(f);
        }
    }

    public final String toString() {
        return super.toString() + "|setAddressTagUnread";
    }
}
