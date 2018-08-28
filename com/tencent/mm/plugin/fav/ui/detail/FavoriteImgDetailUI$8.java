package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.widget.snackbar.b;

class FavoriteImgDetailUI$8 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteImgDetailUI jcT;

    FavoriteImgDetailUI$8(FavoriteImgDetailUI favoriteImgDetailUI, Dialog dialog) {
        this.jcT = favoriteImgDetailUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
        b.h(this.jcT, this.jcT.getString(i.fav_finish_sent));
    }
}
