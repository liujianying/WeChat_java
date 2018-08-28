package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.sdk.platformtools.x;

class FavImgGalleryUI$8 implements Runnable {
    final /* synthetic */ FavImgGalleryUI iYT;
    final /* synthetic */ int iYU;

    FavImgGalleryUI$8(FavImgGalleryUI favImgGalleryUI, int i) {
        this.iYT = favImgGalleryUI;
        this.iYU = i;
    }

    public final void run() {
        if (this.iYU != -1) {
            x.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[]{Integer.valueOf(this.iYU)});
            FavImgGalleryUI.g(this.iYT).setSelection(this.iYU);
            FavImgGalleryUI.a(this.iYT, this.iYU);
        } else if (FavImgGalleryUI.c(this.iYT) - 1 >= 0 && FavImgGalleryUI.c(this.iYT) - 1 < FavImgGalleryUI.h(this.iYT).size()) {
            x.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[]{Integer.valueOf(FavImgGalleryUI.c(this.iYT) - 1), Integer.valueOf(FavImgGalleryUI.h(this.iYT).size())});
            FavImgGalleryUI.g(this.iYT).setSelection(FavImgGalleryUI.c(this.iYT) - 1);
            FavImgGalleryUI.a(this.iYT, FavImgGalleryUI.c(this.iYT) - 1);
        } else if (FavImgGalleryUI.h(this.iYT).size() > 0) {
            x.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[]{Integer.valueOf(FavImgGalleryUI.h(this.iYT).size())});
            FavImgGalleryUI.g(this.iYT).setSelection(0);
            FavImgGalleryUI.a(this.iYT, 0);
        } else {
            x.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[]{Integer.valueOf(FavImgGalleryUI.h(this.iYT).size())});
            this.iYT.finish();
        }
    }
}
