package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.video.o.a;

class o$a$4 implements Runnable {
    final /* synthetic */ a oCn;
    final /* synthetic */ int oCo;
    final /* synthetic */ String sl;

    o$a$4(a aVar, String str, int i) {
        this.oCn = aVar;
        this.sl = str;
        this.oCo = i;
    }

    public final void run() {
        if (this.oCn.oCk.oCd != null && this.oCn.oCk.oAb != null) {
            com.tencent.mm.plugin.topstory.a.b.a aVar = this.oCn.oCk.oAb.bHU().oAm;
            if (aVar != null && aVar.ozc == 0) {
                aVar.ozc = System.currentTimeMillis() - aVar.oyQ;
            }
            this.oCn.oCk.oCd.L(this.sl, this.oCo);
            if (this.oCo != 0) {
                com.tencent.mm.plugin.websearch.api.a.a.kB(9);
            } else {
                com.tencent.mm.plugin.websearch.api.a.a.kB(27);
            }
        }
    }
}
