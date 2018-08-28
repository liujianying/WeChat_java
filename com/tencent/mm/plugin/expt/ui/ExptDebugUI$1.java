package com.tencent.mm.plugin.expt.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExptDebugUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExptDebugUI iIU;

    ExptDebugUI$1(ExptDebugUI exptDebugUI) {
        this.iIU = exptDebugUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iIU.finish();
        return true;
    }
}
