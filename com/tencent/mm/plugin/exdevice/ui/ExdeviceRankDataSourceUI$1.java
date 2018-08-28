package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceRankDataSourceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceRankDataSourceUI iFe;

    ExdeviceRankDataSourceUI$1(ExdeviceRankDataSourceUI exdeviceRankDataSourceUI) {
        this.iFe = exdeviceRankDataSourceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ExdeviceRankDataSourceUI.a(this.iFe);
        return true;
    }
}
