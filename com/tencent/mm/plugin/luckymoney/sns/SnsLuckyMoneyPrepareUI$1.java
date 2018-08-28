package com.tencent.mm.plugin.luckymoney.sns;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLuckyMoneyPrepareUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI kTy;

    SnsLuckyMoneyPrepareUI$1(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.kTy = snsLuckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kTy.finish();
        return true;
    }
}
