package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PhoneRechargeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$1(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mqa.YC();
        this.mqa.finish();
        return true;
    }
}
