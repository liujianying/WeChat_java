package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;

class FavoriteSightDetailUI$7 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteSightDetailUI jdp;

    FavoriteSightDetailUI$7(FavoriteSightDetailUI favoriteSightDetailUI, Dialog dialog) {
        this.jdp = favoriteSightDetailUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
    }
}
