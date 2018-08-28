package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class HardCoderSettingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ HardCoderSettingUI uzO;

    HardCoderSettingUI$1(HardCoderSettingUI hardCoderSettingUI) {
        this.uzO = hardCoderSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uzO.finish();
        return true;
    }
}
