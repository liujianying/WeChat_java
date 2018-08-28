package com.tencent.mm.ui.conversation;

import com.tencent.mm.aa.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class j$9 implements Runnable {
    final /* synthetic */ j ure;

    j$9(j jVar) {
        this.ure = jVar;
    }

    public final void run() {
        a c = j.c(this.ure);
        q.Kp().d(c);
        au.HU();
        c.DT().a(c);
        c.cyF();
    }
}
