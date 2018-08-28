package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;

class AppAttachDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppAttachDownloadUI tGp;

    AppAttachDownloadUI$1(AppAttachDownloadUI appAttachDownloadUI) {
        this.tGp = appAttachDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (AppAttachDownloadUI.a(this.tGp) != null) {
            au.DF().c(AppAttachDownloadUI.a(this.tGp));
        }
        this.tGp.finish();
        return true;
    }
}
