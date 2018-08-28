package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ImageGalleryGridUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ImageGalleryGridUI tUJ;

    ImageGalleryGridUI$5(ImageGalleryGridUI imageGalleryGridUI) {
        this.tUJ = imageGalleryGridUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tUJ.onBackPressed();
        return true;
    }
}
