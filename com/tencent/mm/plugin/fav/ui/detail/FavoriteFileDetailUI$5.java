package com.tencent.mm.plugin.fav.ui.detail;

class FavoriteFileDetailUI$5 implements Runnable {
    final /* synthetic */ String jcA;
    final /* synthetic */ FavoriteFileDetailUI jcx;
    final /* synthetic */ float jcz;

    FavoriteFileDetailUI$5(FavoriteFileDetailUI favoriteFileDetailUI, float f, String str) {
        this.jcx = favoriteFileDetailUI;
        this.jcz = f;
        this.jcA = str;
    }

    public final void run() {
        FavoriteFileDetailUI.p(this.jcx).setProgress((int) this.jcz);
        FavoriteFileDetailUI.q(this.jcx).setText(this.jcA);
    }
}
