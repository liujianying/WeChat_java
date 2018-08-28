package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectCreateQRCodeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CollectCreateQRCodeUI hXF;

    CollectCreateQRCodeUI$1(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.hXF = collectCreateQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hXF.setResult(0);
        this.hXF.finish();
        return true;
    }
}
