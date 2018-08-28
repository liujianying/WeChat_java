package com.tencent.mm.plugin.gallery.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectAlbumPreviewFolderUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectAlbumPreviewFolderUI jEF;

    SelectAlbumPreviewFolderUI$1(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        this.jEF = selectAlbumPreviewFolderUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jEF.finish();
        return false;
    }
}
