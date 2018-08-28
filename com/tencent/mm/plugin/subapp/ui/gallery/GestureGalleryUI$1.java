package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GestureGalleryUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GestureGalleryUI osu;

    GestureGalleryUI$1(GestureGalleryUI gestureGalleryUI) {
        this.osu = gestureGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.osu.finish();
        return true;
    }
}
