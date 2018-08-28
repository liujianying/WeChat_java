package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingDeleteAccountAgreementUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingDeleteAccountAgreementUI mQJ;

    SettingDeleteAccountAgreementUI$3(SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI) {
        this.mQJ = settingDeleteAccountAgreementUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQJ.YC();
        this.mQJ.finish();
        return true;
    }
}
