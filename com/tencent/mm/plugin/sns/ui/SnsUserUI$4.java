package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsUserUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$4(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ohd.finish();
        return true;
    }
}
