package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class FavoriteSightDetailUI$4$2$1$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ 1 jdt;

    FavoriteSightDetailUI$4$2$1$1(1 1, p pVar) {
        this.jdt = 1;
        this.jcG = pVar;
    }

    public final void run() {
        this.jdt.jds.jdr.jdp.jcb.iVR = true;
        this.jcG.dismiss();
        x.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[]{Long.valueOf(this.jdt.jds.jdr.jdp.jaq.field_localId), Integer.valueOf(this.jdt.jds.jdr.jdp.jaq.field_id)});
        this.jdt.jds.jdr.jdp.finish();
    }
}
