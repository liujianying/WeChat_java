package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class FavoriteTextDetailUI$2$2$1$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ 1 jdC;

    FavoriteTextDetailUI$2$2$1$1(1 1, p pVar) {
        this.jdC = 1;
        this.jcG = pVar;
    }

    public final void run() {
        this.jdC.jdB.jdA.jdz.jcb.iVR = true;
        this.jcG.dismiss();
        x.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[]{Long.valueOf(FavoriteTextDetailUI.b(this.jdC.jdB.jdA.jdz))});
        this.jdC.jdB.jdA.jdz.finish();
    }
}
