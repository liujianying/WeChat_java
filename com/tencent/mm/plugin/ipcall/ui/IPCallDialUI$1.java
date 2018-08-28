package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallDialUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallDialUI kvy;

    IPCallDialUI$1(IPCallDialUI iPCallDialUI) {
        this.kvy = iPCallDialUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kvy.finish();
        return true;
    }
}
