package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiIntroductionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiIntroductionUI jnu;

    FreeWifiIntroductionUI$1(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.jnu = freeWifiIntroductionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jnu.finish();
        return false;
    }
}
