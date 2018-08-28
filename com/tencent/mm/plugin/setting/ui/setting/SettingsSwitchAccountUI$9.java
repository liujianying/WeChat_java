package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;

class SettingsSwitchAccountUI$9 implements OnClickListener {
    final /* synthetic */ SettingsSwitchAccountUI mUe;

    SettingsSwitchAccountUI$9(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        this.mUe = settingsSwitchAccountUI;
    }

    public final void onClick(View view) {
        SettingsSwitchAccountUI.b(this.mUe, false);
        SettingsSwitchAccountUI.a(this.mUe, false);
        SettingsSwitchAccountUI.d(this.mUe).setDeleteState(false);
        SettingsSwitchAccountUI.d(this.mUe).bum();
        SettingsSwitchAccountUI.e(this.mUe);
    }
}
