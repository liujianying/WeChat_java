package com.tencent.mm.plugin.fav.ui.detail;

class FavoriteSightDetailUI$6 implements Runnable {
    final /* synthetic */ int fdk;
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$6(FavoriteSightDetailUI favoriteSightDetailUI, int i) {
        this.jdp = favoriteSightDetailUI;
        this.fdk = i;
    }

    public final void run() {
        FavoriteSightDetailUI.c(this.jdp).setProgress(this.fdk);
    }
}
