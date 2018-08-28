package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.plugin.fav.b.d.c.a;

class c$2 implements Runnable {
    final /* synthetic */ c iXM;
    final /* synthetic */ a iXN;

    c$2(c cVar, a aVar) {
        this.iXM = cVar;
        this.iXN = aVar;
    }

    public final void run() {
        c.a(this.iXN, false);
    }

    public final String toString() {
        return super.toString() + "|retryJob";
    }
}
