package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.protocal.c.caz;

class q$8 implements Runnable {
    final /* synthetic */ q ftZ;
    final /* synthetic */ int fua;
    final /* synthetic */ caz fub;

    q$8(q qVar, int i, caz caz) {
        this.ftZ = qVar;
        this.fua = i;
        this.fub = caz;
    }

    public final void run() {
        q.a(this.ftZ, "cmdId " + this.fua + ", errCode " + this.fub.bMH);
    }
}
