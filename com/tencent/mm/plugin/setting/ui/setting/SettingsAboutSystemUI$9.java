package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsAboutSystemUI$9 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;

    SettingsAboutSystemUI$9(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.mRk = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mRk.duR.edit().putBoolean("settings_voicerecorder_mode", true).commit();
        ((CheckBoxPreference) SettingsAboutSystemUI.a(this.mRk).ZZ("settings_voicerecorder_mode")).qpJ = true;
        SettingsAboutSystemUI.a(this.mRk).notifyDataSetChanged();
    }
}
