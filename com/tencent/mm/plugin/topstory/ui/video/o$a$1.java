package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.video.o.a;
import com.tencent.mm.sdk.platformtools.x;

class o$a$1 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dPG;
    final /* synthetic */ a oCn;
    final /* synthetic */ String sl;

    o$a$1(a aVar, int i, int i2, String str) {
        this.oCn = aVar;
        this.dPF = i;
        this.dPG = i2;
        this.sl = str;
    }

    public final void run() {
        if (this.oCn.oCk.oCd != null && this.oCn.oCk.oAb != null) {
            com.tencent.mm.plugin.topstory.a.b.a aVar = this.oCn.oCk.oAb.bHU().oAm;
            if (aVar != null && aVar.ozd == 0) {
                aVar.ozd = System.currentTimeMillis() - aVar.oyQ;
                aVar.oze = (long) this.dPF;
                aVar.ozf = (long) (this.dPF + this.dPG);
                x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[]{Long.valueOf(aVar.ozd), Integer.valueOf(this.dPF), Integer.valueOf(this.dPG)});
            }
            this.oCn.oCk.oCd.iB(this.dPF);
        }
    }
}
