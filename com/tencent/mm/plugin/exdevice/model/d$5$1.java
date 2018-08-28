package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.d.5;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;

class d$5$1 extends a {
    final /* synthetic */ 5 itr;

    d$5$1(5 5) {
        this.itr = 5;
        super(0);
    }

    public final void onServiceConnected() {
        d.a(this.itr.itl).iyE = null;
        e.aHw().an(this.itr.itp, this.itr.itq);
        synchronized (d.b(this.itr.itl)) {
            d.b(this.itr.itl).notify();
        }
    }
}
