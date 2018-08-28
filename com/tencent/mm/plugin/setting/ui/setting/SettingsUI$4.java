package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsUI$4 implements OnClickListener {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$4(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.RT().commitNow();
        if (SettingsUI.i(this.mUx) == null || !SettingsUI.i(this.mUx).isChecked()) {
            x.i("MicroMsg.SettingsUI", "normally exit");
            h.mEJ.a(99, 144, 1, false);
            h.mEJ.h(11545, Integer.valueOf(7));
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
            if (!(g.DF() == null || g.DF().dJs == null)) {
                g.DF().dJs.bD(false);
            }
            SettingsUI.k(this.mUx);
            return;
        }
        x.i("MicroMsg.SettingsUI", "push notify mode exit");
        h.mEJ.a(99, 143, 1, false);
        h.mEJ.h(11545, Integer.valueOf(6));
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
        aa.US().edit().putBoolean("is_in_notify_mode", true).commit();
        SettingsUI.j(this.mUx);
    }
}
