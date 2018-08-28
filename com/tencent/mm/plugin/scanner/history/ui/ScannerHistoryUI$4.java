package com.tencent.mm.plugin.scanner.history.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ScannerHistoryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ScannerHistoryUI mFo;

    ScannerHistoryUI$4(ScannerHistoryUI scannerHistoryUI) {
        this.mFo = scannerHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ScannerHistoryUI.b(this.mFo);
        return true;
    }
}
