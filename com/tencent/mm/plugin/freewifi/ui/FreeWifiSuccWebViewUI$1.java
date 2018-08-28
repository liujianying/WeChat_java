package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiSuccWebViewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiSuccWebViewUI jon;

    FreeWifiSuccWebViewUI$1(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        this.jon = freeWifiSuccWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jon.finish();
        FreeWifiSuccWebViewUI.a(this.jon);
        return true;
    }
}
