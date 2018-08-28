package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ui.base.h.a;

class SettingsNotificationUI$4 implements a {
    final /* synthetic */ int fyo;
    final /* synthetic */ SettingsNotificationUI mTf;

    SettingsNotificationUI$4(SettingsNotificationUI settingsNotificationUI, int i) {
        this.mTf = settingsNotificationUI;
        this.fyo = i;
    }

    public final void vh(int i) {
        if (this.fyo != i) {
            SettingsNotificationUI.vQ(i);
        }
    }
}
