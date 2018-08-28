package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountInputPassUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountInputPassUI mQM;

    SettingDeleteAccountInputPassUI$1(SettingDeleteAccountInputPassUI settingDeleteAccountInputPassUI) {
        this.mQM = settingDeleteAccountInputPassUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQM.YC();
        this.mQM.finish();
        return true;
    }
}
