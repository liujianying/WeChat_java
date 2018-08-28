package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallMyGiftCardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallMyGiftCardUI kwG;

    IPCallMyGiftCardUI$1(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        this.kwG = iPCallMyGiftCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kwG.finish();
        return true;
    }
}
