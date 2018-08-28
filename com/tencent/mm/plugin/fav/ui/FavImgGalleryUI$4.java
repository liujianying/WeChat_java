package com.tencent.mm.plugin.fav.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FavImgGalleryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FavImgGalleryUI iYT;

    FavImgGalleryUI$4(FavImgGalleryUI favImgGalleryUI) {
        this.iYT = favImgGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iYT.finish();
        return true;
    }
}
