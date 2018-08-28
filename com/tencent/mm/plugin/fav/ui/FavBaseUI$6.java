package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$6 implements e {
    final /* synthetic */ FavBaseUI iYp;

    FavBaseUI$6(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
        if (((aj) lVar).iWW) {
            x.i("MicroMsg.FavoriteBaseUI", "need batch get return");
            return;
        }
        x.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
        if (FavBaseUI.c(this.iYp)) {
            FavBaseUI.d(this.iYp);
        }
        this.iYp.eP(false);
        this.iYp.aMg();
    }
}
