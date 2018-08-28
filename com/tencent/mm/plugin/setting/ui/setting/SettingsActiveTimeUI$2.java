package com.tencent.mm.plugin.setting.ui.setting;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

class SettingsActiveTimeUI$2 implements OnTimeSetListener {
    final /* synthetic */ SettingsActiveTimeUI mRJ;

    SettingsActiveTimeUI$2(SettingsActiveTimeUI settingsActiveTimeUI) {
        this.mRJ = settingsActiveTimeUI;
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        if (SettingsActiveTimeUI.a(this.mRJ)) {
            SettingsActiveTimeUI.a(this.mRJ, i);
            SettingsActiveTimeUI.b(this.mRJ, i2);
            SettingsActiveTimeUI.b(this.mRJ);
        } else {
            SettingsActiveTimeUI.c(this.mRJ, i);
            SettingsActiveTimeUI.d(this.mRJ, i2);
            SettingsActiveTimeUI.c(this.mRJ);
        }
        this.mRJ.initView();
    }
}
