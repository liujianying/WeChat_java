package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.k.f;
import com.tencent.mm.model.as;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

class SettingsNotificationUI$3 implements OnClickListener {
    final /* synthetic */ SettingsNotificationUI mTf;

    SettingsNotificationUI$3(SettingsNotificationUI settingsNotificationUI) {
        this.mTf = settingsNotificationUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.bh(true);
        ((CheckBoxPreference) SettingsNotificationUI.a(this.mTf).ZZ("settings_new_voip_msg_notification")).qpJ = true;
        this.mTf.initView();
        as.j(false, true);
    }
}
