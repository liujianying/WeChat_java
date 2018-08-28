package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.sdk.platformtools.al.a;

class SettingsSelectBgUI$1 implements a {
    final /* synthetic */ SettingsSelectBgUI mTS;

    SettingsSelectBgUI$1(SettingsSelectBgUI settingsSelectBgUI) {
        this.mTS = settingsSelectBgUI;
    }

    public final boolean vD() {
        if (this.mTS.findViewById(f.settings_select_bg_gv).getWidth() <= 0) {
            return true;
        }
        SettingsSelectBgUI.a(this.mTS);
        return false;
    }
}
