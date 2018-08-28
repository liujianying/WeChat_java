package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class StartUnbindQQ$1 implements OnMenuItemClickListener {
    final /* synthetic */ StartUnbindQQ eJj;

    StartUnbindQQ$1(StartUnbindQQ startUnbindQQ) {
        this.eJj = startUnbindQQ;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eJj.finish();
        return true;
    }
}
