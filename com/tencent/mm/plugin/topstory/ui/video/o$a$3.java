package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.video.o.a;

class o$a$3 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dVx;
    final /* synthetic */ a oCn;
    final /* synthetic */ String sl;

    o$a$3(a aVar, String str, int i, int i2) {
        this.oCn = aVar;
        this.sl = str;
        this.dPF = i;
        this.dVx = i2;
    }

    public final void run() {
        if (this.oCn.oCk.oCd != null) {
            this.oCn.oCk.oCd.h(this.sl, this.dPF, this.dVx);
        }
        if (o.G((long) ((this.dPF * 100) / this.dVx), (long) this.dPF)) {
            this.oCn.bIC();
        }
    }
}
