package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FavImgGalleryUI$6 implements OnCancelListener {
    final /* synthetic */ FavImgGalleryUI iYT;

    FavImgGalleryUI$6(FavImgGalleryUI favImgGalleryUI) {
        this.iYT = favImgGalleryUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        FavImgGalleryUI.b(this.iYT);
    }
}
