package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallAllRecordUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAllRecordUI kuu;

    IPCallAllRecordUI$1(IPCallAllRecordUI iPCallAllRecordUI) {
        this.kuu = iPCallAllRecordUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kuu.finish();
        return true;
    }
}
