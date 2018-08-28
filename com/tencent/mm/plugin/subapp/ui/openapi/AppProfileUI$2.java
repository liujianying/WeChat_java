package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppProfileUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppProfileUI osO;

    AppProfileUI$2(AppProfileUI appProfileUI) {
        this.osO = appProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.osO.finish();
        return true;
    }
}
