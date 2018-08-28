package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.widget.snackbar.b;

class FavImgGalleryUI$10 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavImgGalleryUI iYT;

    FavImgGalleryUI$10(FavImgGalleryUI favImgGalleryUI, Dialog dialog) {
        this.iYT = favImgGalleryUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
        b.h(this.iYT, this.iYT.getString(i.fav_finish_sent));
    }
}
