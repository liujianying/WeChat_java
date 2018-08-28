package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

class FavBaseUI$7 implements e {
    final /* synthetic */ FavBaseUI iYp;

    FavBaseUI$7(FavBaseUI favBaseUI) {
        this.iYp = favBaseUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FavoriteBaseUI", "on batch get end");
        if (FavBaseUI.c(this.iYp)) {
            x.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
            FavBaseUI.d(this.iYp);
            this.iYp.eP(false);
        }
    }
}
