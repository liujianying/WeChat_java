package com.tencent.mm.plugin.kitchen.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class KvInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ KvInfoUI kAs;

    KvInfoUI$1(KvInfoUI kvInfoUI) {
        this.kAs = kvInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kAs.finish();
        return true;
    }
}
