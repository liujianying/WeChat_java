package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MallGalleryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MallGalleryUI lSt;

    MallGalleryUI$3(MallGalleryUI mallGalleryUI) {
        this.lSt = mallGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lSt.finish();
        return false;
    }
}
