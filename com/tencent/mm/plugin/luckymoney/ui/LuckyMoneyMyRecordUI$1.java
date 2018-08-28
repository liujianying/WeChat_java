package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyMyRecordUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$1(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kVL.finish();
        return true;
    }
}
