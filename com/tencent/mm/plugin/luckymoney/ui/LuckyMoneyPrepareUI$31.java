package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyPrepareUI$31 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI kWX;

    LuckyMoneyPrepareUI$31(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.kWX = luckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LuckyMoneyPrepareUI.s(this.kWX);
        return true;
    }
}
