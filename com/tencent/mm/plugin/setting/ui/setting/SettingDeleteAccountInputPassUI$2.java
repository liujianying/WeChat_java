package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountInputPassUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountInputPassUI mQM;

    SettingDeleteAccountInputPassUI$2(SettingDeleteAccountInputPassUI settingDeleteAccountInputPassUI) {
        this.mQM = settingDeleteAccountInputPassUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQM.YC();
        this.mQM.startActivity(new Intent(this.mQM, SettingDeleteAccountUI.class));
        return true;
    }
}
