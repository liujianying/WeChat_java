package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;

class FavoriteVideoPlayUI$3 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteVideoPlayUI jdN;

    FavoriteVideoPlayUI$3(FavoriteVideoPlayUI favoriteVideoPlayUI, Dialog dialog) {
        this.jdN = favoriteVideoPlayUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
    }
}
