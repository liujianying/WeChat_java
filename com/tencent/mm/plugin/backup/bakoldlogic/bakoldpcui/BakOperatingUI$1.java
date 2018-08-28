package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakOperatingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$1(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!BakOperatingUI.a(this.haO)) {
            BakOperatingUI.b(this.haO);
            BakOperatingUI.c(this.haO);
        }
        return true;
    }
}
