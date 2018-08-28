package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingsFacePrintManagerUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsFacePrintManagerUI iSd;

    SettingsFacePrintManagerUI$3(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        this.iSd = settingsFacePrintManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iSd.finish();
        return true;
    }
}
