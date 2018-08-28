package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakePersonalInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakePersonalInfoUI mZR;

    ShakePersonalInfoUI$1(ShakePersonalInfoUI shakePersonalInfoUI) {
        this.mZR = shakePersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mZR.finish();
        return true;
    }
}
