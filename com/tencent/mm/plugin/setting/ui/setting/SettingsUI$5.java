package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$5 implements OnClickListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$5(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(11545, new Object[]{Integer.valueOf(5)});
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
    }
}
