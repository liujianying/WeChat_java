package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingSnsBackgroundUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SettingSnsBackgroundUI nRb;

    SettingSnsBackgroundUI$5(SettingSnsBackgroundUI settingSnsBackgroundUI) {
        this.nRb = settingSnsBackgroundUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nRb.finish();
        return true;
    }
}
