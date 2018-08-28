package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetPerformanceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetPerformanceUI fxY;

    WxaWidgetPerformanceUI$1(WxaWidgetPerformanceUI wxaWidgetPerformanceUI) {
        this.fxY = wxaWidgetPerformanceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.fxY.finish();
        return false;
    }
}
