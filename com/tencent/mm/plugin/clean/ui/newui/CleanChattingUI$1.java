package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanChattingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanChattingUI hTu;

    CleanChattingUI$1(CleanChattingUI cleanChattingUI) {
        this.hTu = cleanChattingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hTu.finish();
        return false;
    }
}
