package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class SettingsPrivacyUI$1 implements Runnable {
    final /* synthetic */ int hMp;
    final /* synthetic */ SettingsPrivacyUI mTv;

    SettingsPrivacyUI$1(SettingsPrivacyUI settingsPrivacyUI, int i) {
        this.mTv = settingsPrivacyUI;
        this.hMp = i;
    }

    public final void run() {
        View a = ((a) SettingsPrivacyUI.a(this.mTv)).a(this.hMp, this.mTv.kww);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.mTv.mController.tml, a);
        }
    }
}
