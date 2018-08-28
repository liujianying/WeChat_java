package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class UnfamiliarContactDetailUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ UnfamiliarContactDetailUI mUT;

    UnfamiliarContactDetailUI$5(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.mUT = unfamiliarContactDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mUT.finish();
        return true;
    }
}
