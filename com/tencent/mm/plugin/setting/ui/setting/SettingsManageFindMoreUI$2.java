package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsManageFindMoreUI$2 implements Runnable {
    final /* synthetic */ CheckBoxPreference mSG;
    final /* synthetic */ SettingsManageFindMoreUI mSH;

    SettingsManageFindMoreUI$2(SettingsManageFindMoreUI settingsManageFindMoreUI, CheckBoxPreference checkBoxPreference) {
        this.mSH = settingsManageFindMoreUI;
        this.mSG = checkBoxPreference;
    }

    public final void run() {
        this.mSG.qpJ = true;
    }
}
