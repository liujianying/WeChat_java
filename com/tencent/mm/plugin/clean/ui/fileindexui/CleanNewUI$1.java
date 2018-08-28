package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanNewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$1(CleanNewUI cleanNewUI) {
        this.hTh = cleanNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hTh.finish();
        return false;
    }
}
