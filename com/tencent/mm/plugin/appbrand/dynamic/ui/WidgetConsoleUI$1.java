package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WidgetConsoleUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WidgetConsoleUI fxP;

    WidgetConsoleUI$1(WidgetConsoleUI widgetConsoleUI) {
        this.fxP = widgetConsoleUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.fxP.finish();
        return false;
    }
}
