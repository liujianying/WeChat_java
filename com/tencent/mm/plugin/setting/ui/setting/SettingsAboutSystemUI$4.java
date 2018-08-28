package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsAboutSystemUI$4 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;
    final /* synthetic */ CheckBoxPreference mRq;
    final /* synthetic */ boolean mRr;

    SettingsAboutSystemUI$4(SettingsAboutSystemUI settingsAboutSystemUI, CheckBoxPreference checkBoxPreference, boolean z) {
        this.mRk = settingsAboutSystemUI;
        this.mRq = checkBoxPreference;
        this.mRr = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mRq.qpJ = this.mRr;
        SettingsAboutSystemUI.a(this.mRk).notifyDataSetChanged();
    }
}
