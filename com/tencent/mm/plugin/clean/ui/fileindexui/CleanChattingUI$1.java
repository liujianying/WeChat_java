package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$1(CleanChattingUI cleanChattingUI) {
        this.hSr = cleanChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hSr.finish();
        return false;
    }
}
