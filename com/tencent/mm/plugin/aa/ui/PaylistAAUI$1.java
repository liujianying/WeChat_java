package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PaylistAAUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ PaylistAAUI eEl;

    PaylistAAUI$1(PaylistAAUI paylistAAUI) {
        this.eEl = paylistAAUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eEl.finish();
        return false;
    }
}
