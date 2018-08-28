package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;

class FavSearchUI$1 implements Runnable {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$1(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final void run() {
        FavSearchUI.a(this.iZQ, ((ae) g.n(ae.class)).getFavItemInfoStorage().aLJ());
    }
}
