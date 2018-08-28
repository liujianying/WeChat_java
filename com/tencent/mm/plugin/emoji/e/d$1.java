package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aa.a;

class d$1 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ d ifr;

    d$1(d dVar, String str) {
        this.ifr = dVar;
        this.ewx = str;
    }

    public final void run() {
        this.ifr.zg(this.ewx);
        if (this.ifr.ifp) {
            au.HU();
            c.DT().a(a.sPc, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
