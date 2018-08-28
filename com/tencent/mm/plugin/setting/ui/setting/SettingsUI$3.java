package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$3 implements OnClickListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$3(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(11545, Integer.valueOf(2));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
        if (SettingsUI.g(this.mUx) != null) {
            SettingsUI.g(this.mUx).dismiss();
        }
    }
}
