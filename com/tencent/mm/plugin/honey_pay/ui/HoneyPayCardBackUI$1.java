package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class HoneyPayCardBackUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ HoneyPayCardBackUI kke;

    HoneyPayCardBackUI$1(HoneyPayCardBackUI honeyPayCardBackUI) {
        this.kke = honeyPayCardBackUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kke.YC();
        this.kke.Wq();
        this.kke.finish();
        return false;
    }
}
