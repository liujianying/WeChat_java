package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

class SettingsPersonalMoreUI$1 implements a {
    final /* synthetic */ SettingsPersonalMoreUI mTi;

    SettingsPersonalMoreUI$1(SettingsPersonalMoreUI settingsPersonalMoreUI) {
        this.mTi = settingsPersonalMoreUI;
    }

    public final boolean a(Preference preference, Object obj) {
        String str = (String) obj;
        if ("male".equalsIgnoreCase(str)) {
            SettingsPersonalMoreUI.a(this.mTi, 1);
        } else if ("female".equalsIgnoreCase(str)) {
            SettingsPersonalMoreUI.a(this.mTi, 2);
        }
        return false;
    }
}
