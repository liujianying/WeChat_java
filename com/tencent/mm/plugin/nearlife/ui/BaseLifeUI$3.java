package com.tencent.mm.plugin.nearlife.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseLifeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BaseLifeUI lDH;

    BaseLifeUI$3(BaseLifeUI baseLifeUI) {
        this.lDH = baseLifeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lDH.a(-1, false, "");
        this.lDH.finish();
        return true;
    }
}
