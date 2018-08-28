package com.tencent.mm.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

class h$16 implements Runnable {
    final /* synthetic */ h tiG;

    h$16(h hVar) {
        this.tiG = hVar;
    }

    public final void run() {
        h.a(this.tiG, q.GJ());
        h.b(this.tiG, q.GQ());
        h.a(this.tiG, q.GK());
        long currentTimeMillis = System.currentTimeMillis();
        h.s(this.tiG);
        x.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
