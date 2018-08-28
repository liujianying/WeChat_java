package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeItemListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeItemListUI mZA;

    ShakeItemListUI$5(ShakeItemListUI shakeItemListUI) {
        this.mZA = shakeItemListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mZA.YC();
        this.mZA.finish();
        return true;
    }
}
