package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLuckyMoneyDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLuckyMoneyDetailUI nmg;

    SnsLuckyMoneyDetailUI$2(SnsLuckyMoneyDetailUI snsLuckyMoneyDetailUI) {
        this.nmg = snsLuckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nmg.finish();
        return true;
    }
}
