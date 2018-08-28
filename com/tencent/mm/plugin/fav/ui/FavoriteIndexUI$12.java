package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteIndexUI$12 implements e {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$12(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        this.jbh.iYg.post(new 1(this));
    }
}
