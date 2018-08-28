package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MultiStageCitySelectUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MultiStageCitySelectUI uBd;

    MultiStageCitySelectUI$5(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.uBd = multiStageCitySelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MultiStageCitySelectUI.l(this.uBd);
        this.uBd.finish();
        return true;
    }
}
