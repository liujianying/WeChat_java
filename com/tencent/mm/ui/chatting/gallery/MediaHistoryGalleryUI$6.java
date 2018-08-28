package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MediaHistoryGalleryUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ MediaHistoryGalleryUI tXF;

    MediaHistoryGalleryUI$6(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.tXF = mediaHistoryGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tXF.cwx();
        return true;
    }
}
