package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallRechargeUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallRechargeUI kxB;

    IPCallRechargeUI$5(IPCallRechargeUI iPCallRechargeUI) {
        this.kxB = iPCallRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kxB.finish();
        return true;
    }
}
