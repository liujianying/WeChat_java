package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.report.service.h;

class SettingsAboutMicroMsgUI$6 implements OnCancelListener {
    final /* synthetic */ SettingsAboutMicroMsgUI mRb;

    SettingsAboutMicroMsgUI$6(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.mRb = settingsAboutMicroMsgUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        h.mEJ.a(405, 23, 1, true);
    }
}
