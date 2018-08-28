package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SetTextSizeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SetTextSizeUI mQI;

    SetTextSizeUI$1(SetTextSizeUI setTextSizeUI) {
        this.mQI = setTextSizeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQI.YC();
        this.mQI.finish();
        return true;
    }
}
