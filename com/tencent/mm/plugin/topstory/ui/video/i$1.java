package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.a.c;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ i oAi;

    i$1(i iVar) {
        this.oAi = iVar;
    }

    public final void run() {
        if (this.oAi.oAg != null) {
            x.i("MicroMsg.TopStory.TopStoryVideoFullScreenMgr", "exitFullScreen %d", new Object[]{Integer.valueOf(this.oAi.oAg.getPosition())});
            c a = h.a(this.oAi.oAb);
            if (a != null) {
                this.oAi.oAb.yg(a.position);
                a.z(this.oAi.oAg);
                o bHS = this.oAi.oAb.bHS();
                if (bHS.oCd != null) {
                    bHS.oCd.bS(true);
                }
            }
            this.oAi.jMc = false;
        }
    }
}
