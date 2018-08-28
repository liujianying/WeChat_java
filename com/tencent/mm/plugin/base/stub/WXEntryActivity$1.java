package com.tencent.mm.plugin.base.stub;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WXEntryActivity$1 implements OnMenuItemClickListener {
    final /* synthetic */ WXEntryActivity hef;

    WXEntryActivity$1(WXEntryActivity wXEntryActivity) {
        this.hef = wXEntryActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WXEntryActivity.a(this.hef);
        return false;
    }
}
