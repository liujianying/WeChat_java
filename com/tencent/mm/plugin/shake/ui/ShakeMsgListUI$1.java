package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeMsgListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$1(ShakeMsgListUI shakeMsgListUI) {
        this.mZP = shakeMsgListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mZP.YC();
        this.mZP.finish();
        return true;
    }
}
