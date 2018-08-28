package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RechargeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$1(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mqE.YC();
        this.mqE.finish();
        return true;
    }
}
