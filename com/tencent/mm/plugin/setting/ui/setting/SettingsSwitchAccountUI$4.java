package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.ui.base.h;

class SettingsSwitchAccountUI$4 implements c {
    final /* synthetic */ SettingsSwitchAccountUI mUe;

    SettingsSwitchAccountUI$4(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        this.mUe = settingsSwitchAccountUI;
    }

    public final void KZ(String str) {
        h.a(this.mUe, this.mUe.getString(i.settings_switch_account_delete_alert, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.c(this.mUe).get(str)).username}), this.mUe.getString(i.app_tip), this.mUe.getString(i.app_yes), this.mUe.getString(i.app_no), new 1(this, str), null);
    }
}
