package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GestureGuardLogicUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$1(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!GestureGuardLogicUI.a(this.pHr)) {
            GestureGuardLogicUI.a(this.pHr, 0, 4, "user cancel when setting gesture");
        }
        return true;
    }
}
