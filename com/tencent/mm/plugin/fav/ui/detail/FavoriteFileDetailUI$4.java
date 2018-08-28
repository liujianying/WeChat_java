package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;

class FavoriteFileDetailUI$4 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$4(FavoriteFileDetailUI favoriteFileDetailUI, Dialog dialog) {
        this.jcx = favoriteFileDetailUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
    }
}
