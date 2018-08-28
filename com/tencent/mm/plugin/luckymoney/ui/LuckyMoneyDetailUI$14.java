package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyDetailUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$14(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kVo.finish();
        return true;
    }
}
