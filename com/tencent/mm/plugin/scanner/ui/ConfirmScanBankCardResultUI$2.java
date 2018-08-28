package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ConfirmScanBankCardResultUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ConfirmScanBankCardResultUI mIg;

    ConfirmScanBankCardResultUI$2(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        this.mIg = confirmScanBankCardResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mIg.finish();
        return true;
    }
}
