package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.2.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class FavoriteImgDetailUI$2$2$1$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ 1 jcW;

    FavoriteImgDetailUI$2$2$1$1(1 1, p pVar) {
        this.jcW = 1;
        this.jcG = pVar;
    }

    public final void run() {
        this.jcW.jcV.jcU.jcT.jcb.iVR = true;
        this.jcG.dismiss();
        x.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.jcW.jcV.jcU.jcT.jcO.field_localId)});
        this.jcW.jcV.jcU.jcT.finish();
    }
}
