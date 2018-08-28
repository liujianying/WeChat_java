package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class IPCallShareCouponCardUI$13 implements d {
    final /* synthetic */ IPCallShareCouponCardUI kyi;

    IPCallShareCouponCardUI$13(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.kyi = iPCallShareCouponCardUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        IPCallShareCouponCardUI.a(this.kyi, menuItem.getItemId());
    }
}
