package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$2 implements OnClickListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$2(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(11545, Integer.valueOf(3));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
        h.mEJ.a(99, 145, 1, false);
        if (!(g.DF() == null || g.DF().dJs == null)) {
            g.DF().dJs.bD(false);
        }
        if (SettingsUI.g(this.mUx) != null) {
            SettingsUI.g(this.mUx).dismiss();
        }
        SettingsUI.h(this.mUx);
    }
}
