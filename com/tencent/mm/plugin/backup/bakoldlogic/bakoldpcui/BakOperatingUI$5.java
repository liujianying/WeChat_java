package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakOperatingUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$5(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (BakOperatingUI.a(this.haO)) {
            BakOperatingUI.e(this.haO);
            return false;
        }
        BakOperatingUI.b(this.haO);
        BakOperatingUI.f(this.haO);
        return true;
    }
}
