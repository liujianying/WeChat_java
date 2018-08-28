package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.a.b;

class FavoriteSightDetailUI$5 implements Runnable {
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$5(FavoriteSightDetailUI favoriteSightDetailUI) {
        this.jdp = favoriteSightDetailUI;
    }

    public final void run() {
        if (!FavoriteSightDetailUI.a(this.jdp).isDone() || !b.f(FavoriteSightDetailUI.b(this.jdp)) || FavoriteSightDetailUI.d(this.jdp) == null || !FavoriteSightDetailUI.d(this.jdp).isPlaying()) {
            FavoriteSightDetailUI.a(this.jdp, true);
        }
    }
}
