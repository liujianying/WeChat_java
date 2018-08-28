package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;

class d$4 extends c$a {
    final /* synthetic */ d itl;
    final /* synthetic */ Runnable ito;

    public d$4(d dVar, Runnable runnable) {
        this.itl = dVar;
        this.ito = runnable;
        super(0);
    }

    public final void onServiceConnected() {
        this.ito.run();
    }
}
