package com.tencent.mm.plugin.exdevice.service;

class e$1 implements Runnable {
    final /* synthetic */ String itp;
    final /* synthetic */ boolean itq;
    final /* synthetic */ e iyI;

    e$1(e eVar, String str, boolean z) {
        this.iyI = eVar;
        this.itp = str;
        this.itq = z;
    }

    public final void run() {
        if (u.aHG().isY != null) {
            u.aHG().isY.a(this.itp, this.itq, this.iyI);
        }
    }
}
