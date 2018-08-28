package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;

class ImageDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ImageDownloadUI tMw;

    ImageDownloadUI$1(ImageDownloadUI imageDownloadUI) {
        this.tMw = imageDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        au.DF().c(ImageDownloadUI.a(this.tMw));
        this.tMw.finish();
        return true;
    }
}
