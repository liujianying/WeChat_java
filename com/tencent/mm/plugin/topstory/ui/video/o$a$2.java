package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.video.o.a;

class o$a$2 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dPG;
    final /* synthetic */ a oCn;
    final /* synthetic */ String sl;

    o$a$2(a aVar, String str, int i, int i2) {
        this.oCn = aVar;
        this.sl = str;
        this.dPF = i;
        this.dPG = i2;
    }

    public final void run() {
        if (this.oCn.oCk.oCd != null) {
            this.oCn.oCk.oCd.onDataAvailable(this.sl, this.dPF, this.dPG);
        }
    }
}
