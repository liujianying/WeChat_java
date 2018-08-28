package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.2.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class FavoriteFileDetailUI$13$2$2$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ 2 jcH;

    FavoriteFileDetailUI$13$2$2$1(2 2, p pVar) {
        this.jcH = 2;
        this.jcG = pVar;
    }

    public final void run() {
        this.jcH.jcF.jcE.jcx.jcb.iVR = true;
        this.jcG.dismiss();
        x.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(FavoriteFileDetailUI.b(this.jcH.jcF.jcE.jcx).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.jcH.jcF.jcE.jcx).field_id)});
        this.jcH.jcF.jcE.jcx.finish();
    }
}
