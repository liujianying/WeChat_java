package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallShareCouponUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$8(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kyP.finish();
        return true;
    }
}
