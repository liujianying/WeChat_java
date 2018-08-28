package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetDebugUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetDebugUI fxT;

    WxaWidgetDebugUI$1(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.fxT = wxaWidgetDebugUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.fxT.finish();
        return false;
    }
}
