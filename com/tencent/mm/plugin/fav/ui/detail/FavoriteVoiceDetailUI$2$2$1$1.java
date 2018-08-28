package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class FavoriteVoiceDetailUI$2$2$1$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ long jdV;
    final /* synthetic */ long jdW;
    final /* synthetic */ 1 jdX;

    FavoriteVoiceDetailUI$2$2$1$1(1 1, p pVar, long j, long j2) {
        this.jdX = 1;
        this.jcG = pVar;
        this.jdV = j;
        this.jdW = j2;
    }

    public final void run() {
        this.jdX.jdU.jdT.jdS.jcb.iVR = true;
        this.jcG.dismiss();
        x.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[]{Long.valueOf(this.jdV), Long.valueOf(this.jdW)});
        this.jdX.jdU.jdT.jdS.finish();
    }
}
