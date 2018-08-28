package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyCanShareListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyCanShareListUI kUU;

    LuckyMoneyCanShareListUI$1(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        this.kUU = luckyMoneyCanShareListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kUU.finish();
        return true;
    }
}
