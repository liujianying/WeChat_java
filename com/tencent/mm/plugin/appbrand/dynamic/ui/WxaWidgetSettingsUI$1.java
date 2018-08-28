package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetSettingsUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetSettingsUI fyb;

    WxaWidgetSettingsUI$1(WxaWidgetSettingsUI wxaWidgetSettingsUI) {
        this.fyb = wxaWidgetSettingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.fyb.finish();
        return false;
    }
}
