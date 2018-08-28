package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class HoneyPayBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ HoneyPayBaseUI kjW;

    HoneyPayBaseUI$1(HoneyPayBaseUI honeyPayBaseUI) {
        this.kjW = honeyPayBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kjW.YC();
        this.kjW.Wq();
        this.kjW.finish();
        return false;
    }
}
