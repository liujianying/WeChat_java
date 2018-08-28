package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaBindBizInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaBindBizInfoUI gwZ;

    WxaBindBizInfoUI$1(WxaBindBizInfoUI wxaBindBizInfoUI) {
        this.gwZ = wxaBindBizInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.gwZ.finish();
        return false;
    }
}
