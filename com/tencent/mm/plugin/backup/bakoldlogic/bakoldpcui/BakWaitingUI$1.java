package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakWaitingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakWaitingUI haV;

    BakWaitingUI$1(BakWaitingUI bakWaitingUI) {
        this.haV = bakWaitingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BakWaitingUI.a(this.haV);
        return true;
    }
}
