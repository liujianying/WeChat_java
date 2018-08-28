package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseScanUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$13(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BaseScanUI.i(this.mHS);
        return false;
    }
}
