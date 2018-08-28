package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.appusage.o.a;

class o$a$1 implements Runnable {
    final /* synthetic */ String fhM;
    final /* synthetic */ a fmr;

    o$a$1(a aVar, String str) {
        this.fmr = aVar;
        this.fhM = str;
    }

    public final void run() {
        a.rm(this.fhM);
    }
}
