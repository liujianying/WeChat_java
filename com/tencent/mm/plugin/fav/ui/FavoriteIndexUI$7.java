package com.tencent.mm.plugin.fav.ui;

import java.util.ArrayList;

class FavoriteIndexUI$7 implements Runnable {
    final /* synthetic */ FavoriteIndexUI jbh;
    final /* synthetic */ ArrayList jbm;

    FavoriteIndexUI$7(FavoriteIndexUI favoriteIndexUI, ArrayList arrayList) {
        this.jbh = favoriteIndexUI;
        this.jbm = arrayList;
    }

    public final void run() {
        this.jbh.iXX = true;
        g.be(this.jbm);
    }
}
