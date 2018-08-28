package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;

class c$3 implements Runnable {
    final /* synthetic */ c fld;
    final /* synthetic */ boolean fle;
    final /* synthetic */ long flf;
    final /* synthetic */ Bundle flg;

    c$3(c cVar, boolean z, long j, Bundle bundle) {
        this.fld = cVar;
        this.fle = z;
        this.flf = j;
        this.flg = bundle;
    }

    public final void run() {
        c.a(this.fld, 3, ((this.fle & 1) != 0 ? 2 : 0) | 1, this.flf, this.fle, this.flg);
    }
}
