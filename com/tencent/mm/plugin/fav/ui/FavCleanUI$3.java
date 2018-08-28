package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.d.a;
import com.tencent.mm.sdk.platformtools.x;

class FavCleanUI$3 implements a {
    final /* synthetic */ FavCleanUI iYA;

    FavCleanUI$3(FavCleanUI favCleanUI) {
        this.iYA = favCleanUI;
    }

    public final void onFinish() {
        x.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
        FavCleanUI.c(this.iYA);
        FavCleanUI.d(this.iYA);
    }
}
