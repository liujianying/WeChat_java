package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.FavSearchUI.8;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavSearchUI$8$1 implements Runnable {
    final /* synthetic */ List iZR;
    final /* synthetic */ List iZS;
    final /* synthetic */ List iZT;
    final /* synthetic */ 8 iZU;

    FavSearchUI$8$1(8 8, List list, List list2, List list3) {
        this.iZU = 8;
        this.iZR = list;
        this.iZS = list2;
        this.iZT = list3;
    }

    public final void run() {
        FavSearchUI.a(this.iZU.iZQ, this.iZR, this.iZS, this.iZT);
        x.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[]{this.iZR, this.iZS, this.iZT});
        FavSearchUI.b(this.iZU.iZQ, this.iZS);
        FavSearchUI.c(this.iZU.iZQ, this.iZT);
        FavSearchUI.d(this.iZU.iZQ, this.iZR);
        FavSearchUI.d(this.iZU.iZQ).bf(this.iZT);
        FavSearchUI.e(this.iZU.iZQ).b(this.iZR, this.iZS, this.iZT);
        FavSearchUI.a(this.iZU.iZQ, false);
    }
}
