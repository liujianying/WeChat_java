package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.widget.snackbar.b;

class FavoriteIndexUI$5 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$5(FavoriteIndexUI favoriteIndexUI, Dialog dialog) {
        this.jbh = favoriteIndexUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
        b.h(this.jbh, this.jbh.getString(i.fav_finish_sent));
    }
}
