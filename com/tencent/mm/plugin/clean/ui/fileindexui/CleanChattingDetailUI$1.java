package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingDetailUI hSj;

    CleanChattingDetailUI$1(CleanChattingDetailUI cleanChattingDetailUI) {
        this.hSj = cleanChattingDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hSj.finish();
        return false;
    }
}
