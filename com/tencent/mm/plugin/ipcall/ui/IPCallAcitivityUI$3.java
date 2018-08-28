package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallAcitivityUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAcitivityUI ktx;

    IPCallAcitivityUI$3(IPCallAcitivityUI iPCallAcitivityUI) {
        this.ktx = iPCallAcitivityUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ktx.finish();
        return true;
    }
}
