package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;

class d$6 extends c$a {
    final /* synthetic */ boolean fEU;
    final /* synthetic */ d itl;
    final /* synthetic */ String its;
    final /* synthetic */ long itt;

    d$6(d dVar, int i, String str, long j, boolean z) {
        this.itl = dVar;
        this.its = str;
        this.itt = j;
        this.fEU = z;
        super(i);
    }

    public final void onServiceConnected() {
        d.a(this.itl).iyE = null;
        this.itl.b(this.its, this.itt, this.bLL, this.fEU);
    }
}
